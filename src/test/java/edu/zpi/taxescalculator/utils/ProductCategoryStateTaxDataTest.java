package edu.zpi.taxescalculator.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryStateTaxDataTest {

    ProductCategoryStateTaxData productCategoryStateTaxData = new ProductCategoryStateTaxData(ProductCategory.CLOTHING, 4, true);

    @Test
    void isTaxIncluded() {
        assertEquals(true, productCategoryStateTaxData.isTaxIncluded());
    }

    @Test
    void getProductCategory() {
        assertEquals(ProductCategory.CLOTHING, productCategoryStateTaxData.getProductCategory());
    }

    @Test
    void getTax() {
        assertEquals(4, productCategoryStateTaxData.getTax());
    }
}