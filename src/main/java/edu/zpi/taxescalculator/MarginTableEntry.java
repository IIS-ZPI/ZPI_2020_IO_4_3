package edu.zpi.taxescalculator;

public class MarginTableEntry {
    private String stateName;
    private double stockPrice;
    private double margin;
    private double price;
    private double baseTax;

    public MarginTableEntry(String stateName, double stockPrice, double margin, double price, double baseTax) {
        this.stateName = stateName;
        this.stockPrice = stockPrice;
        this.margin = margin;
        this.price = price;
        this.baseTax = baseTax;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBaseTax() {
        return baseTax;
    }

    public void setBaseTax(double baseTax) {
        this.baseTax = baseTax;
    }
}
