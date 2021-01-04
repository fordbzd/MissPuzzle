package org.misspuzzle.leetcode;

import org.junit.Test;
import org.misspuzzle.puzzle.leetcode.Q6_ZigZagConversion;

import static org.junit.Assert.assertEquals;

public class Q6_Test {

    @Test
    public void testZigZagConversion() {
        final String result = new Q6_ZigZagConversion().convert("PAYPALISHIRING", 200);

        assertEquals(result, "PAYPALISHIRING");
    }
}
