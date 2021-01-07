package org.misspuzzle.puzzle.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q6_Test {

    @Test
    public void testcase() {
        final String result = new Q6_ZigZagConversion().convert("PAYPALISHIRING", 200);

        assertEquals("PAYPALISHIRING", result);
    }
}
