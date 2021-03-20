package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q12_Test {
    @Test
    public void testcase1() {
        final String result = new Q12_IntToRoman().intToRoman(58);

        assertEquals("LVIII", result);
    }

    @Test
    public void testcase2() {
        final String result = new Q12_IntToRoman().intToRoman(1994);

        assertEquals("MCMXCIV", result);
    }
}
