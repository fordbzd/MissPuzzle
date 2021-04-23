package org.misspuzzle.puzzle.leetcode.p500;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q554_LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (List<Integer> row : wall) {
            int index = 0;

            for (int i = 0; i < row.size() - 1; i++) {
                index += row.get(i);
                map.put(index, map.getOrDefault(index, 0) + 1);
            }
        }

        for (Integer col : map.values()) {
            max = Math.max(max, col);
        }

        return wall.size() - max;
    }
}
