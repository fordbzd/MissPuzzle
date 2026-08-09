package org.misspuzzle.puzzle.leetcode.p1400;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q1461_Test {
    @Test
    public void testcase() {

        boolean result = new Q1461_HasAllCodes().hasAllCodes("00110", 2);

        assertTrue(result);
    }
}
