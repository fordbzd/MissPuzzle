package org.misspuzzle.puzzle.leetcode.p400;

public class Q376_WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        boolean isPositive = false;
        int count = 1;
        int start = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                start = i;
                isPositive = nums[i] - nums[i - 1] > 0;
                count = 2;
                break;
            }
        }

        for (int i = start + 1; i < nums.length; i++) {
            if (isPositive && nums[i] - nums[i - 1] < 0) {
                count++;
                isPositive = false;
            }

            if (!isPositive && nums[i] - nums[i - 1] > 0) {
                count++;
                isPositive = true;
            }
        }

        return count;
    }
}
