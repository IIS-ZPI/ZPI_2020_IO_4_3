package edu.zpi.taxescalculator.utils;

import edu.zpi.taxescalculator.utils.MarginTableEntry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarginTableEntryTest {

    private MarginTableEntry marginTableEntry = new MarginTableEntry("Alabama", "124", "49.98", "173.88", "4.00", "4.00", "180.83");

    @Test
    void getStateName() {
        assertEquals("Alabama", marginTableEntry.getStateName());
    }

    @Test
    void getWholesalePrice() {
        assertEquals("124", marginTableEntry.getWholesalePrice());
    }

    @Test
    void getMargin() {
        assertEquals("49.98", marginTableEntry.getMargin());
    }

    @Test
    void getPrice() {
        assertEquals("173.88", marginTableEntry.getPrice());
    }

    @Test
    void getBaseTax() {
        assertEquals("4.00", marginTableEntry.getBaseTax());
    }

    @Test
    void getPriceWithoutTax() {
        assertEquals("4.00", marginTableEntry.getPriceWithoutTax());
    }

    @Test
    void getFinalTax() {
        assertEquals("180.83", marginTableEntry.getFinalTax());
    }
}
