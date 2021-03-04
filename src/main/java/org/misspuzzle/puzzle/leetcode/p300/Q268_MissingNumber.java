package org.misspuzzle.puzzle.leetcode.p300;

import java.util.Arrays;

public class Q268_MissingNumber {
    public int missingNumber(int[] nums) {
        return (nums.length * (nums.length + 1) / 2) - Arrays.stream(nums).reduce(0, Integer::sum);
    }
}
