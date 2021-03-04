package org.misspuzzle.puzzle.leetcode.p700;

public class Q645_FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        for (int num : nums) {
            int i = Math.abs(num) - 1;

            if (nums[i] < 0) {
                result[0] = Math.abs(num);
            } else {
                nums[i] = -nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
                break;
            }
        }

        return result;
    }

}
