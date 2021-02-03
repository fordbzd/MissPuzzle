package org.misspuzzle.puzzle.leetcode.p1500;

public class Q1437_KLengthApart {

    public boolean kLengthApart(int[] nums, int k) {
        int pos = -nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - pos < k) {
                    return false;
                }

                pos = i + 1;
            }
        }

        return true;
    }
}
