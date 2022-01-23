package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Q321_Test {
    @Test
    public void testcase() {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};

        int[] result = new Q321_MaxNumber().maxNumber(nums1, nums2, 5);

        assertArrayEquals(new int[]{9, 8, 6, 5, 3}, result);
    }
}
