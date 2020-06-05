package edu.zpi.taxescalculator.utils;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * CLass represents a single entry for margins table
 */

public class MarginTableEntry {
    private String stateName;
    private String wholesalePrice;
    private String quantity;
    private String wholesaleValue;
    private String margin;
    private String valueIncludingTax;
    private String baseTax;
    private String valueExcludingTax;
    private String taxValue;
    private String tax;

    private MarginTableEntry() {
    }

    /**
     * Create a new instance of MarginTableEntry
     *
     * @param stateName         Name of the state
     * @param wholesaleValue    Value in stock
     * @param margin            Purchase margin
     * @param valueIncludingTax Final price
     * @param baseTax           Basic tax
     * @param valueExcludingTax Product price without tax
     * @param tax               Final tax, which contains base tax and category tax
     */
    public MarginTableEntry(String stateName, String wholesaleValue, String margin, String valueExcludingTax, String baseTax, String tax, String valueIncludingTax) {
        this.stateName = stateName;
        this.wholesaleValue = wholesaleValue;
        this.margin = margin;
        this.valueIncludingTax = valueIncludingTax;
        this.baseTax = baseTax;
        this.valueExcludingTax = valueExcludingTax;
        this.tax = tax;
    }

    public static List<MarginTableEntry> createEntriesList(Product product, double calculationValue, String calculationType) throws IOException {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        var margins = product.calculateMargins(calculationValue, calculationType);
        var exemptions = product.createStatesAndTaxExemptionsMap();
        if (margins == null)
            return null;

        var quantity = product.getQuantity();

        List<MarginTableEntry> entries = new ArrayList<>();
        final var statesAndTaxesMap = product.createStatesAndTaxesMap();
        margins.forEach((state, margin) -> {
            var wholesaleValue = product.getWholesalePrice() * quantity;
            var valueExcludingTax = product.getWholesalePrice() * quantity + margin;
            var finalTax = exemptions.get(state) != null && valueExcludingTax > exemptions.get(state) ? state.getBaseTax() / 100 : statesAndTaxesMap.get(state) / 100;
            var valueIncludingTax = valueExcludingTax * (1 + finalTax);

            var tableEntry = new MarginTableEntry();

            tableEntry.setStateName(state.getStateName());
            tableEntry.setQuantity(nf.format(quantity));
            tableEntry.setWholesalePrice(nf.format(product.getWholesalePrice()));
            tableEntry.setWholesaleValue(nf.format(wholesaleValue));
            tableEntry.setMargin(nf.format(margin));
            tableEntry.setValueExcludingTax(nf.format(valueExcludingTax));
            tableEntry.setBaseTax(nf.format(state.getBaseTax()));
            tableEntry.setTax(nf.format(finalTax * 100));
            tableEntry.setTaxValue(nf.format(valueExcludingTax * finalTax));
            tableEntry.setValueIncludingTax(nf.format(valueIncludingTax));

            entries.add(tableEntry);

        });

        return entries;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getWholesaleValue() {
        return wholesaleValue;
    }

    public void setWholesaleValue(String wholesaleValue) {
        this.wholesaleValue = wholesaleValue;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getValueIncludingTax() {
        return valueIncludingTax;
    }

    public void setValueIncludingTax(String valueIncludingTax) {
        this.valueIncludingTax = valueIncludingTax;
    }

    public String getBaseTax() {
        return baseTax;
    }

    public void setBaseTax(String baseTax) {
        this.baseTax = baseTax;
    }

    public String getValueExcludingTax() {
        return valueExcludingTax;
    }

    public void setValueExcludingTax(String valueExcludingTax) {
        this.valueExcludingTax = valueExcludingTax;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(String wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(String taxValue) {
        this.taxValue = taxValue;
    }
}
