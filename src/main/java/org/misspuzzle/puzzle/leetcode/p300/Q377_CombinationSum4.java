package org.misspuzzle.puzzle.leetcode.p300;

import java.util.HashMap;
import java.util.Map;

public class Q377_CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {

        return dfs(nums, target, new HashMap<>());
    }

    private int dfs(int[] nums, int target, Map<Integer, Integer> cache) {

        int count = 0;

        for (int num : nums) {
            if (num < target) {
                if (cache.containsKey(target - num)) {
                    count += cache.get(target - num);
                } else {
                    count += dfs(nums, target - num, cache);
                }
            } else if (num == target) {
                count++;
            }
        }

        cache.put(target, count);

        return count;
    }
}
