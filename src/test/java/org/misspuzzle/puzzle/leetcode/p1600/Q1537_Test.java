package org.misspuzzle.puzzle.leetcode.p1600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1537_Test {
    @Test
    public void testcase() {
        int[] nums1 = {2, 4, 5, 8, 10};
        int[] nums2 = {4, 6, 8, 9};

        int result = new Q1537_MaxSum().maxSum(nums1, nums2);

        assertEquals(30, result);
    }
}
