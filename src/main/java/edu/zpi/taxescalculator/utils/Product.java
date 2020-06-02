package edu.zpi.taxescalculator.utils;

import java.io.IOException;
import java.util.*;

/**
 * Class that stores basic information about single product
 */

public class Product {
    private final String productName;
    private final double unitWholesalePrice;
    private final int quantity;
    private final ProductCategory category;
    private Map<State, Double> unitMargins;

    /**
     * Create a new instance of Product with specified product name, stock price and minimal expected purchase margin
     *
     * @param productName        Name of product
     * @param unitWholesalePrice Product price in stock
     * @param category           Product's category
     */
    public Product(String productName, double unitWholesalePrice, int quantity, ProductCategory category) {
        this.productName = productName;
        this.unitWholesalePrice = unitWholesalePrice;
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
        if (calculationType.equalsIgnoreCase("min_margin"))
            return calculateMarginsBasedOnMinMargin(statesAndTaxesMap, value);
        else if (calculationType.equalsIgnoreCase("expected_price"))
            return calculateMarginsBasedOnExpectedPrice(statesAndTaxesMap, value);
        else
            return null;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitWholesalePrice() {
        return unitWholesalePrice;
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
                tax = optionalCategoryTax.get().getTax() / 100.0;
            }
            statesAndTaxesMap.put(k, tax);
        });
        return statesAndTaxesMap;
    }

    /**
     * Generate map of the states and the corresponding margin
     *
     * @param states    Map of states and taxes to calculate margins
     * @param minMargin Minimal expected purchase margin
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    private HashMap<State, Double> calculateMarginsBasedOnMinMargin(Map<State, Double> states, double minMargin) {
        double maxTax = states.values().stream().max(Double::compareTo).orElse(0.0);
        double maxPrice = (unitWholesalePrice + minMargin) * (1 + maxTax);
        return calculateMarginsBasedOnExpectedPrice(states, maxPrice);
    }

    /**
     * Generate map of the states and the corresponding margin
     *
     * @param states        Map of states and taxes to calculate margins
     * @param expectedPrice Expected final price
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    private HashMap<State, Double> calculateMarginsBasedOnExpectedPrice(Map<State, Double> states, double expectedPrice) {
        states.forEach((state, tax) -> {
            double statePrice = expectedPrice / (1 + tax);
            double stateMargin = statePrice - unitWholesalePrice;
            unitMargins.put(state, stateMargin);
        });
        return getUnitMargins();
    }
}
