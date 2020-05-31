package edu.zpi.taxescalculator.utils;

import java.util.*;

/**
 * Class that stores basic information about single product
 */

public class Product {
    private String productName;
    private double unitWholesalePrice;
    private Map<State, Double> unitMargins;
    private int quantity;

    /**
     * Create a new instance of Product with specified product name, stock price and minimal expected purchase margin
     *
     * @param productName    Name of product
     * @param unitWholesalePrice Product price in stock
     */
    public Product(String productName, double unitWholesalePrice, int quantity) {
        this.productName = productName;
        this.unitWholesalePrice = unitWholesalePrice;
        unitMargins = new HashMap<>();
        this.quantity = quantity;
    }

    /**
     * Generate map of the states and the corresponding margin
     *
     * @param states            Map of states and taxes to calculate margins
     * @param value             Value corresponding to chosen calculation type
     * @param calculationType   Type of calculation (min margin or expected price)
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    public HashMap<State, Double> calculateMargins(Map<State, Double> states, double value, String calculationType) {
        if (calculationType.equalsIgnoreCase("min_margin"))
            return calculateMarginsBasedOnMinMargin(states, value);
        else if (calculationType.equalsIgnoreCase("expected_price"))
            return calculateMarginsBasedOnExpectedPrice(states, value);
        else
            return null;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitWholesalePrice() {
        return unitWholesalePrice;
    }

    public void setUnitWholesalePrice(double unitWholesalePrice) {
        this.unitWholesalePrice = unitWholesalePrice;
    }

    public HashMap<State, Double> getUnitMargins() {
        return new HashMap<>(unitMargins);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
