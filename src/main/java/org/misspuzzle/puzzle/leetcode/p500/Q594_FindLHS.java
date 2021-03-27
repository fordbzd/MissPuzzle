package org.misspuzzle.puzzle.leetcode.p500;

import java.util.HashMap;
import java.util.Map;

public class Q594_FindLHS {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int count = map.containsKey(n) ? map.get(n) : 0;

            map.put(n, count + 1);
        }

        int max = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int n = entry.getKey();
            int count = entry.getValue();

            if (map.containsKey(n + 1)) {
                max = Math.max(max, count + map.get(n + 1));
            }
        }

        return max;
    }
}
