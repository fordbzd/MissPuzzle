package org.misspuzzle.puzzle.leetcode.p1500;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q1461_Test {
    @Test
    public void testcase() {

        boolean result = new Q1461_HasAllCodes().hasAllCodes("00110", 2);

        assertTrue(result);
    }
}
