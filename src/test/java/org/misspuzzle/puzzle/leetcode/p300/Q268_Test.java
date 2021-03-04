package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q268_Test {
    @Test
    public void testcase() {
        final int[] nums = {3, 0, 1};

        final int result = new Q268_MissingNumber().missingNumber(nums);

        assertEquals(2, result);
    }
}
