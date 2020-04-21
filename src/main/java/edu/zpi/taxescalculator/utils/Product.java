package edu.zpi.taxescalculator.utils;

import java.util.*;

/**
 * Class that stores basic information about single product
 */

public class Product {
    private String productName;
    private double wholesalePrice;
    private double minMargin;
    private SortedMap<State, Double> margins;

    /**
     * Create a new instance of Product with specified product name, stock price and minimal expected purchase margin
     * @param productName Name of product
     * @param wholesalePrice Product price in stock
     * @param minMargin Minimal expected purchase margin
     */
    public Product(String productName, double wholesalePrice, double minMargin) {
        this.productName = productName;
        this.wholesalePrice = wholesalePrice;
        this.minMargin = minMargin;
        margins = new TreeMap<>();
    }

    /**
     * Generate map of the states and the corresponding margin
     * @param states List of states to calculate margins
     * @return Map of states and margins, where Key is the state and Value is the corresponding margin
     */
    public SortedMap<State, Double> calculateMargins(List<State> states) {
        double maxTax = states.stream().mapToDouble(State::getBaseTax).max().orElse(0);
        double maxPrice = (wholesalePrice + minMargin) * (1 + maxTax);
        states.forEach(state -> {
            double statePrice = maxPrice / (1 + state.getBaseTax());
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

    public SortedMap<State, Double> getMargins() {
        return margins;
    }

    public double getMinMargin() {
        return minMargin;
    }

    public void setMinMargin(double minMargin) {
        this.minMargin = minMargin;
    }
}
