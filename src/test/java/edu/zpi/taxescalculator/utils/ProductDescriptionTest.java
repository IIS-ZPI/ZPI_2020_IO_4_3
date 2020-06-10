package edu.zpi.taxescalculator.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDescriptionTest {
    ProductDescription productDescription = new ProductDescription("orange", "Orange", "/images/product/orange.jpg");

    @Test
    void getCodeName() {
        assertEquals("orange", productDescription.getCodeName());
    }

    @Test
    void getDisplayName() {
        assertEquals("Orange", productDescription.getDisplayName());
    }

    @Test
    void getImg() {
        assertEquals("/images/product/orange.jpg", productDescription.getImg());
    }
}