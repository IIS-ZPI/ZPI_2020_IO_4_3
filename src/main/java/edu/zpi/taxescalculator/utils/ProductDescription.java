package edu.zpi.taxescalculator.utils;

public class ProductDescription {
    private final String codeName;
    private final String displayName;
    private final String img;

    public ProductDescription(String codeName, String displayName, String img) {
        this.codeName = codeName;
        this.displayName = displayName;
        this.img = img;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getImg() {
        return img;
    }
}
