package org.misspuzzle.puzzle.leetcode.p000;

public class Q45_Jump {
    public int jump(int[] nums) {
        int[] step = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    step[i + j] = step[i + j] == 0 ? step[i] + 1 : Math.min(step[i] + 1, step[i + j]);
                }
            }
        }

        return step[nums.length - 1];
    }
}
