package edu.zpi.taxescalculator.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class that stores basic information about single product
 */

public class Product {
    private final String productName;
    private final double wholesalePrice;
    private final int quantity;
    private final ProductCategory category;
    private Map<State, Double> unitMargins;

    /**
     * Create a new instance of Product with specified product name, stock price and minimal expected purchase margin
     *
     * @param productName    Name of product
     * @param wholesalePrice Product price in stock
     * @param category       Product's category
     */
    public Product(String productName, double wholesalePrice, int quantity, ProductCategory category) {
        this.productName = productName;
        this.wholesalePrice = wholesalePrice;
        this.category = category;
        unitMargins = new HashMap<>();
        this.quantity = quantity;
    }

    /**
     * Generate map of the states and the corresponding margin
     *
     * @param value           Value corresponding to chosen calculation type
     * @param calculationType Type of calculation (min margin or expected price)
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    public HashMap<State, Double> calculateMargins(double value, String calculationType) throws IOException {
        var statesAndTaxesMap = createStatesAndTaxesMap();
        var exemptions = createStatesAndTaxExemptionsMap();
        if (calculationType.equalsIgnoreCase("min_margin"))
            return calculateMarginsBasedOnMinMargin(statesAndTaxesMap, exemptions, value);
        else if (calculationType.equalsIgnoreCase("expected_price"))
            return calculateMarginsBasedOnExpectedPrice(statesAndTaxesMap, exemptions, value);
        else
            return null;
    }

    public String getProductName() {
        return productName;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public HashMap<State, Double> getUnitMargins() {
        return new HashMap<>(unitMargins);
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public TreeMap<State, Double> createStatesAndTaxesMap() throws IOException {
        var statesAndCategoriesMap = TaxDataParser.fromUrlIncludeCategories("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States");
        var statesAndTaxesMap = new TreeMap<State, Double>();
        statesAndCategoriesMap.forEach((k, v) -> {
            var optionalCategoryTax = v.stream()
                    .filter(el -> el.getProductCategory().equals(category))
                    .findFirst();
            double tax = 0.0;
            if (optionalCategoryTax.isPresent()) {
                tax = optionalCategoryTax.get().getTax();
            }
            statesAndTaxesMap.put(k, tax);
        });
        return statesAndTaxesMap;
    }

    public TreeMap<State, Double> createStatesAndTaxExemptionsMap() throws IOException {
        var statesAndCategoriesMap = TaxDataParser.fromUrlIncludeCategories("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States");
        var statesAndTaxExemptions = new TreeMap<State, Double>();
        statesAndCategoriesMap.forEach((k, v) -> {
            var optionalCategoryTax = v.stream()
                    .filter(el -> el.getProductCategory().equals(category))
                    .findAny();
            if (optionalCategoryTax.isPresent() && optionalCategoryTax.get().getTaxedAbovePrice() != null) {
                statesAndTaxExemptions.put(k, Double.valueOf(optionalCategoryTax.get().getTaxedAbovePrice()));
            }
        });
        return statesAndTaxExemptions;
    }

    /**
     * Generate map of the states and the corresponding margin
     *
     * @param states    Map of states and taxes to calculate margins
     * @param minMargin Minimal expected purchase margin
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    private HashMap<State, Double> calculateMarginsBasedOnMinMargin(Map<State, Double> states, Map<State, Double> exemptions, double minMargin) {
        double maxTax = states.values().stream().max(Double::compareTo).orElse(0.0) / 100;
        double maxPrice = (wholesalePrice + minMargin) * (1 + maxTax);
        return calculateMarginsBasedOnExpectedPrice(states, exemptions, maxPrice);
    }

    /**
     * Generate map of the states and the corresponding margin
     *
     * @param states        Map of states and taxes to calculate margins
     * @param expectedPrice Expected final price
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    private HashMap<State, Double> calculateMarginsBasedOnExpectedPrice(Map<State, Double> states, Map<State, Double> exemptions, double expectedPrice) {
        states.forEach((state, tax) -> {
            double priceWithoutTax = expectedPrice / (1 + tax / 100);
            var edgePrice = exemptions.get(state);
            if (edgePrice != null && expectedPrice > edgePrice) {
                var exTax = state.getBaseTax();
                priceWithoutTax = expectedPrice / (1 + exTax / 100);
            }
            double stateMargin = (priceWithoutTax - wholesalePrice) * quantity;
            unitMargins.put(state, stateMargin);
        });
        return getUnitMargins();
    }
}
