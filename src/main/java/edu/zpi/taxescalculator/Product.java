package edu.zpi.taxescalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
    private String productName;
    private double stockPrice;
    private double minMargin;
    private Map<State, Double> margins;

    public Product(String productName, double stockPrice, double minMargin) {
        this.productName = productName;
        this.stockPrice = stockPrice;
        this.minMargin = minMargin;
        margins = new HashMap<>();
    }

    public Map<State, Double> calculateMargins(List<State> states) {
        double maxTax = states.stream().mapToDouble(State::getBaseTax).max().orElse(0);
        double maxPrice = (stockPrice + minMargin) * (1 + maxTax);
        states.forEach(state -> {
            double statePrice = maxPrice / (1 + state.getBaseTax());
            double stateMargin = statePrice - stockPrice;
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

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Map<State, Double> getMargins() {
        return margins;
    }

    public double getMinMargin() {
        return minMargin;
    }

    public void setMinMargin(double minMargin) {
        this.minMargin = minMargin;
    }
}
