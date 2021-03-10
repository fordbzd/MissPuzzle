package org.misspuzzle.puzzle.leetcode.p1600;

public class Q1537_MaxSum {
    public int maxSum(int[] nums1, int[] nums2) {

        int i1 = 0;
        int i2 = 0;

        long maxSum = 0;

        long preSum1 = 0;
        long preSum2 = 0;

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] > nums2[i2]) {
                preSum2 += nums2[i2];
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                preSum1 += nums1[i1];
                i1++;
            } else {
                maxSum += Math.max(preSum1, preSum2) + nums1[i1];

                preSum1 = 0;
                preSum2 = 0;

                i1++;
                i2++;
            }
        }

        for (int i = i1; i < nums1.length; i++) {
            preSum1 += nums1[i];
        }

        for (int i = i2; i < nums2.length; i++) {
            preSum2 += nums2[i];
        }

        return (int) ((Math.max(preSum1, preSum2) + maxSum) % 1000000007);
    }
}
