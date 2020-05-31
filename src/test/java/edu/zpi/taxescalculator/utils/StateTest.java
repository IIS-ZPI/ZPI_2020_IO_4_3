package edu.zpi.taxescalculator.utils;

import edu.zpi.taxescalculator.utils.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {


    State arizonaState =  new State("Arizona", 5.60);
    State californiaState =  new State("California", 7.25);
    State maineState =  new State("Maine", 5.50);
    State nevadaState =  new State("Nevada", 6.85);
    State newJerseyState =  new State("New Jersey", 6.62);
    State newYorkState =  new State("New York", 4.00);
    State ohioState =  new State("Ohio", 5.75);
    State oregonState =  new State("Oregon", 0.00);
    State puertoRicoState =  new State("Puerto Rico", 10.50);
    State texasState =  new State("Texas", 6.25);


    @Test
    void getStateName() {
        assertEquals("Arizona", arizonaState.getStateName());
        assertEquals("California", californiaState.getStateName());
        assertEquals("Maine", maineState.getStateName());
        assertEquals("Nevada", nevadaState.getStateName());
        assertEquals("New Jersey", newJerseyState.getStateName());
        assertEquals("New York", newYorkState.getStateName());
        assertEquals("Ohio", ohioState.getStateName());
        assertEquals("Oregon", oregonState.getStateName());
        assertEquals("Puerto Rico", puertoRicoState.getStateName());
        assertEquals("Texas", texasState.getStateName());
    }

    @Test
    void getBaseTax() {
        assertEquals(5.60, arizonaState.getBaseTax());
        assertEquals(7.25, californiaState.getBaseTax());
        assertEquals(5.50, maineState.getBaseTax());
        assertEquals(6.85, nevadaState.getBaseTax());
        assertEquals(6.62, newJerseyState.getBaseTax());
        assertEquals(4.00, newYorkState.getBaseTax());
        assertEquals(5.75, ohioState.getBaseTax());
        assertEquals(0.00, oregonState.getBaseTax());
        assertEquals(10.50, puertoRicoState.getBaseTax());
        assertEquals(6.25, texasState.getBaseTax());
    }
}
