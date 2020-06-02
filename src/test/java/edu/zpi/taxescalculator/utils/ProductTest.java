package edu.zpi.taxescalculator.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product = new Product("Milk", 124.00, 1, ProductCategory.GROCERY);
    private Map<State, Double> margins;

    @Test
    void calculateMarginsBasedOnMinMargin() {
    }

    @Test
    void calculateMarginsBasedOnMaxPrice() {
    }

    @Test
    void getProductName() {
        assertEquals("Milk", product.getProductName());
    }

    @Test
    void getWholesalePrice() {
        assertEquals(124.00, product.getUnitWholesalePrice());
    }

    @Test
    void getMargins() {
        //assertEquals(margins, product.getMargins());
    }
}
