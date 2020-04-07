public class State {
    private String stateName;
    private double baseTax;

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
}
