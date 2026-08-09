package org.misspuzzle.puzzle.leetcode.p1700;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q1704_Test {
    @Test
    public void testcase() {
        boolean result = new Q1704_HalvesAreAlike().halvesAreAlike("leetcode");

        assertTrue(result);
    }
}
