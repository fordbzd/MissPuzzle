package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q946_Test {
    @Test
    public void testcase() {

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        boolean result = new Q946_ValidateStackSequences().validateStackSequences(pushed, popped);

        assertTrue(result);
    }
}
