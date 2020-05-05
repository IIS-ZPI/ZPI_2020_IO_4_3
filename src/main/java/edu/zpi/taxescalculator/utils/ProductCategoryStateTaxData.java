package edu.zpi.taxescalculator.utils;

import java.util.Optional;

/** @noinspection OptionalUsedAsFieldOrParameterType*/
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class ProductCategoryStateTaxData {

    private ProductCategory productCategory;
    private boolean taxIncluded;
    private Optional<Double> taxValue;
    private double baseStateTax;

    public ProductCategoryStateTaxData(ProductCategory category, double baseTax, boolean included) {
        this.taxIncluded = included;
        this.productCategory = category;
        this.baseStateTax = baseTax;
        this.taxValue = Optional.empty();
    }

    public boolean isTaxIncluded() {
        return this.taxIncluded;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

    public double getTax() {
        if (!this.taxIncluded) return 0.0d;
        return this.taxValue.orElseGet(() -> this.baseStateTax);
    }

    public void setTax(double val) {
        if (this.taxValue.isEmpty()) {
            this.taxValue = Optional.of(val);
        }
    }
}
