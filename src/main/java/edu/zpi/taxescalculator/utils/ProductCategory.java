package edu.zpi.taxescalculator.utils;

import java.util.Map;

public enum ProductCategory {
    GROCERY,
    PREPARED_FOOD,
    PRESCRIPTION_DRUG,
    NON_PRESCRIPTION_DRUG,
    CLOTHING,
    INTANGIBLES;

    private static final Map<ProductCategory, String> plNamesMap = Map.of(
            ProductCategory.CLOTHING, "Ciuchy",
            ProductCategory.GROCERY, "Artykuły spożywcze",
            ProductCategory.INTANGIBLES, "Usługi",
            ProductCategory.NON_PRESCRIPTION_DRUG, "Leki bez recepty",
            ProductCategory.PREPARED_FOOD, "Gotowe jedzenie",
            ProductCategory.PRESCRIPTION_DRUG, "Leki na receptę");

    private static final Map<ProductCategory, String> enNamesMap = Map.of(
            ProductCategory.CLOTHING, "Clothing",
            ProductCategory.GROCERY, "Groceries",
            ProductCategory.INTANGIBLES, "Intangibles",
            ProductCategory.NON_PRESCRIPTION_DRUG, "Non prescription drug",
            ProductCategory.PREPARED_FOOD, "Prepared food",
            ProductCategory.PRESCRIPTION_DRUG, "Prescription drug");

    public String mapToPolishName() {
        return plNamesMap.get(this);
    }

    public String mapToEnglishName() {
        return enNamesMap.get(this);
    }
}
