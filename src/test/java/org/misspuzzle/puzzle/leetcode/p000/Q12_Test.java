package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
