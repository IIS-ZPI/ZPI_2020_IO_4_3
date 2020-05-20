package edu.zpi.taxescalculator.utils;

import java.util.*;

/**
 * Class that stores basic information about single product
 */

public class Product {
    private String productName;
    private double wholesalePrice;
    private Map<State, Double> margins;

    /**
     * Create a new instance of Product with specified product name, stock price and minimal expected purchase margin
     * @param productName Name of product
     * @param wholesalePrice Product price in stock
     */
    public Product(String productName, double wholesalePrice) {
        this.productName = productName;
        this.wholesalePrice = wholesalePrice;
        margins = new HashMap<>();
    }

    /**
     * Generate map of the states and the corresponding margin
     * @param states Map of states and taxes to calculate margins
     * @param minMargin Minimal expected purchase margin
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    public HashMap<State, Double> calculateMarginsBasedOnMinMargin(Map<State, Double> states, double minMargin) {
        double maxTax = states.values().stream().max(Double::compareTo).orElse(0.0);
        double maxPrice = (wholesalePrice + minMargin) * (1 + maxTax);
        return calculateMarginsBasedOnMaxPrice(states, maxPrice);
    }

    public HashMap<State, Double> calculateMarginsBasedOnMaxPrice(Map<State, Double> states, double maxPrice) {
        states.forEach((state, tax) -> {
            double statePrice = maxPrice / (1 + tax);
            double stateMargin = statePrice - wholesalePrice;
            margins.put(state, stateMargin);
        });
        return getMargins();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public HashMap<State, Double> getMargins() {
        return new HashMap<>(margins);
    }
}
