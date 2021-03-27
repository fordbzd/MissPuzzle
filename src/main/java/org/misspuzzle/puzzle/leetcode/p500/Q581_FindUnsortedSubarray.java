package org.misspuzzle.puzzle.leetcode.p500;

public class Q581_FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {

        int length = nums.length;
        int begin = -1;
        int end = -2;
        int max = nums[0];
        int min = nums[length - 1];

        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
            if (max > nums[i]) {
                end = i;
            }

            min = Math.min(min, nums[length - i - 1]);
            if (min < nums[length - i - 1]) {
                begin = length - i - 1;
            }
        }

        return end - begin + 1;
    }
}
