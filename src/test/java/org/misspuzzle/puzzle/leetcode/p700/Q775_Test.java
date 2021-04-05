package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Q775_Test {
    @Test
    public void testcase() {
        int[] nums = {0, 3, 2, 1, 4, 5};

        boolean result = new Q775_IsIdealPermutation().isIdealPermutation(nums);

        assertFalse(result);
    }
}
