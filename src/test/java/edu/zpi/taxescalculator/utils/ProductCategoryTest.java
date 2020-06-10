package edu.zpi.taxescalculator.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryTest {

    ProductCategory productCategory;
    private Map<ProductCategory, String> plNamesMapTest = Map.of(
            ProductCategory.CLOTHING, "Ciuchy",
            ProductCategory.GROCERY, "Artykuły spożywcze",
            ProductCategory.INTANGIBLES, "Usługi",
            ProductCategory.NON_PRESCRIPTION_DRUG, "Leki bez recepty",
            ProductCategory.PREPARED_FOOD, "Gotowe jedzenie",
            ProductCategory.PRESCRIPTION_DRUG, "Leki na receptę");

    private Map<ProductCategory, String> enNamesMapTest = Map.of(
            ProductCategory.CLOTHING, "Clothing",
            ProductCategory.GROCERY, "Groceries",
            ProductCategory.INTANGIBLES, "Intangibles",
            ProductCategory.NON_PRESCRIPTION_DRUG, "Non prescription drug",
            ProductCategory.PREPARED_FOOD, "Prepared food",
            ProductCategory.PRESCRIPTION_DRUG, "Prescription drug");


    @Test
    void mapToPolishName() {
        assertEquals("Ciuchy", ProductCategory.CLOTHING.mapToPolishName());
    }

    @Test
    void mapToEnglishName() {
        assertEquals("Clothing", ProductCategory.CLOTHING.mapToEnglishName());
    }
}