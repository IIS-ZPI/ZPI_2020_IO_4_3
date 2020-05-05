package edu.zpi.taxescalculator.utils;

import java.util.Map;

public enum ProductCategory {
    GROCERY,
    PREPARED_FOOD,
    PRESCRIPTION_DRUG,
    NON_PRESCRIPTION_DRUG,
    CLOTHING,
    INTANGIBLES;

    private static final Map<ProductCategory, String> namesMap = Map.of(ProductCategory.CLOTHING, "Ciuchy",
            ProductCategory.GROCERY, "Artykuły spożywcze",
            ProductCategory.INTANGIBLES, "Usługi",
            ProductCategory.NON_PRESCRIPTION_DRUG, "Leki bez recepty",
            ProductCategory.PREPARED_FOOD, "Gotowe jedzenie",
            ProductCategory.PRESCRIPTION_DRUG, "Leki na receptę");

    public String mapToPolishName() {
        return namesMap.get(this);
    }
}
