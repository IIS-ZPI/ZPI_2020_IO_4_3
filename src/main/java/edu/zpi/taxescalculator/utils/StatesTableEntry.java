package edu.zpi.taxescalculator.utils;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * CLass represents a single entry for states table
 */

public class StatesTableEntry {
    private static final NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);


    private String stateName;
    private String baseTax;
    private String groceryTax;
    private String preparedFoodTax;
    private String prescriptionDrugTax;
    private String nonPrescriptionDrugTax;
    private String clothingTax;
    private String intangiblesTax;

    /**
     * Creates a new instance of StatesTableEntry
     *
     * @param stateName Name of the state
     * @param baseTax   Basic tax
     * @param taxes     List of taxes based on product's categories
     */
    public StatesTableEntry(String stateName, String baseTax, List<ProductCategoryStateTaxData> taxes) {
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        this.stateName = stateName;
        this.baseTax = baseTax;
        initTaxes(taxes);
    }

    private void initTaxes(List<ProductCategoryStateTaxData> taxes) {
        for (var t : taxes) {
            var tax = nf.format(t.getTax());
            switch (t.getProductCategory()) {
                case GROCERY:
                    this.groceryTax = tax;
                    break;
                case CLOTHING:
                    this.clothingTax = tax;
                    break;
                case PRESCRIPTION_DRUG:
                    this.prescriptionDrugTax = tax;
                    break;
                case NON_PRESCRIPTION_DRUG:
                    this.nonPrescriptionDrugTax = tax;
                    break;
                case INTANGIBLES:
                    this.intangiblesTax = tax;
                    break;
                case PREPARED_FOOD:
                    this.preparedFoodTax = tax;
                    break;
            }
        }
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getBaseTax() {
        return baseTax;
    }

    public void setBaseTax(String baseTax) {
        this.baseTax = baseTax;
    }

    public String getGroceryTax() {
        return groceryTax;
    }

    public void setGroceryTax(String groceryTax) {
        this.groceryTax = groceryTax;
    }

    public String getPreparedFoodTax() {
        return preparedFoodTax;
    }

    public void setPreparedFoodTax(String preparedFoodTax) {
        this.preparedFoodTax = preparedFoodTax;
    }

    public String getPrescriptionDrugTax() {
        return prescriptionDrugTax;
    }

    public void setPrescriptionDrugTax(String prescriptionDrugTax) {
        this.prescriptionDrugTax = prescriptionDrugTax;
    }

    public String getNonPrescriptionDrugTax() {
        return nonPrescriptionDrugTax;
    }

    public void setNonPrescriptionDrugTax(String nonPrescriptionDrugTax) {
        this.nonPrescriptionDrugTax = nonPrescriptionDrugTax;
    }

    public String getClothingTax() {
        return clothingTax;
    }

    public void setClothingTax(String clothingTax) {
        this.clothingTax = clothingTax;
    }

    public String getIntangiblesTax() {
        return intangiblesTax;
    }

    public void setIntangiblesTax(String intangiblesTax) {
        this.intangiblesTax = intangiblesTax;
    }
}
