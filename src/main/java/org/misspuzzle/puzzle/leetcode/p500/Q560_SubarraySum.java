package org.misspuzzle.puzzle.leetcode.p500;

import java.util.HashMap;
import java.util.Map;

public class Q560_SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        map.put(0, 1);

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            count += map.getOrDefault(preSum - k, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
