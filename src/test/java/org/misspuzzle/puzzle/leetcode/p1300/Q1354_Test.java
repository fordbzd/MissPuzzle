package org.misspuzzle.puzzle.leetcode.p1300;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q1354_Test {
    @Test
    public void testcase() {

        int[] target = {9, 3, 5};

        boolean result = new Q1354_IsPossible().isPossible(target);

        assertTrue(result);
    }
}
