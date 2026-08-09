package org.misspuzzle.puzzle.leetcode.p400;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q423_Test {
    @Test
    public void testcase() {

        final String result = new Q423_OriginalDigits().originalDigits("retheotwonefiveiennrozefourxissevneeight");

        assertEquals("0123456789", result);
    }
}
