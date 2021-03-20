package org.misspuzzle.puzzle.leetcode.p1400;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1396_Test {
    @Test
    public void testcase() {

        Q1396_UndergroundSystem undergroundSystem = new Q1396_UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        double result = undergroundSystem.getAverageTime("Paradise", "Cambridge");

        assertEquals(14.00000, result, 0.000001);
    }
}
