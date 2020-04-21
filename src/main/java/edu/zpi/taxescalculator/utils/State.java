package edu.zpi.taxescalculator.utils;

/**
 * Class that stores the state and basicTax
 */

public class State implements Comparable<State> {
    private String stateName;
    private double baseTax;

    /**
     * Create a new State instance with specified state name and basic tax
     * @param stateName Name of the state
     * @param baseTax Basic tax on current state
     */
    public State(String stateName, double baseTax) {
        this.stateName = stateName;
        this.baseTax = baseTax;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getBaseTax() {
        return baseTax;
    }

    public void setBaseTax(double baseTax) {
        this.baseTax = baseTax;
    }

    @Override
    public int compareTo(State o) {
        return this.stateName.compareTo(o.stateName);
    }
}
