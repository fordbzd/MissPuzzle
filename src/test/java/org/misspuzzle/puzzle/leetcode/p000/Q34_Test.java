package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q34_Test {
    @Test
    public void testcase() {
        int[] nums = {5, 7, 7, 8, 8, 10};

        final int[] result = new Q34_SearchRange().searchRange(nums, 8);

        assertEquals(3, result[0]);
        assertEquals(4, result[1]);
    }
}
