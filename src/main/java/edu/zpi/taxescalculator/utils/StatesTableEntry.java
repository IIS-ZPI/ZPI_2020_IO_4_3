package edu.zpi.taxescalculator.utils;

/**
 * CLass represents a single entry for states table
 */

public class StatesTableEntry {
    private String stateName;
    private String baseTax;

    /**
     * Creates a new instance of StatesTableEntry
     * @param stateName Name of the state
     * @param baseTax Basic tax
     */
    public StatesTableEntry(String stateName, String baseTax) {
        this.stateName = stateName;
        this.baseTax = baseTax;
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
}
