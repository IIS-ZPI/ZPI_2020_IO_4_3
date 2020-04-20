package edu.zpi.taxescalculator;

/**
 * CLass represents a single entry for margins table
 */

public class MarginTableEntry {
    private String stateName;
    private double wholesalePrice;
    private double margin;
    private double price;
    private double baseTax;

    /**
     * Create a new instance of MarginTableEntry
     * @param stateName Name of the state
     * @param wholesalePrice Price in stock
     * @param margin Purchase margin
     * @param price Final price
     * @param baseTax Basic tax
     */
    public MarginTableEntry(String stateName, double wholesalePrice, double margin, double price, double baseTax) {
        this.stateName = stateName;
        this.wholesalePrice = wholesalePrice;
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

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
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
