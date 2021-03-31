package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q13_Test {
    @Test
    public void testcase() {
        final int result = new Q13_RomanToInt().romanToInt("MCMXCIV");

        assertEquals(1994, result);
    }
}
