package edu.zpi.taxescalculator.utils;

import java.util.Collection;
import java.util.Map;

public class StateFeature {
    private StateFeature() {
    }

    public static State getStateByName(Collection<State> states, String name) {
        return states.stream().filter(s -> name.equalsIgnoreCase(s.getStateName())).findAny().orElse(null);
    }

    public static double getMarginByStateName(Map<State, Double> margins, String name) {
        State state = getStateByName(margins.keySet(), name);
        return margins.get(state);
    }
}
