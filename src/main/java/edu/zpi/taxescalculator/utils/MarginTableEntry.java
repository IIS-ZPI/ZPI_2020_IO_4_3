package edu.zpi.taxescalculator.utils;

/**
 * CLass represents a single entry for margins table
 */

public class MarginTableEntry {
    private String stateName;
    private String wholesalePrice;
    private String margin;
    private String price;
    private String baseTax;
    private String priceWithoutTax;

    /**
     * Create a new instance of MarginTableEntry
     * @param stateName Name of the state
     * @param wholesalePrice Price in stock
     * @param margin Purchase margin
     * @param price Final price
     * @param baseTax Basic tax
     */
    public MarginTableEntry(String stateName, String wholesalePrice, String margin, String price, String baseTax, String priceWithoutTax) {
        this.stateName = stateName;
        this.wholesalePrice = wholesalePrice;
        this.margin = margin;
        this.price = price;
        this.baseTax = baseTax;
        this.priceWithoutTax = priceWithoutTax;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(String wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBaseTax() {
        return baseTax;
    }

    public void setBaseTax(String baseTax) {
        this.baseTax = baseTax;
    }

    public String getPriceWithoutTax() {
        return priceWithoutTax;
    }

    public void setPriceWithoutTax(String priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
    }
}
