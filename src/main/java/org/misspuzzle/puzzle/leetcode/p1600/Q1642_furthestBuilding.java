package org.misspuzzle.puzzle.leetcode.p1600;

import java.util.PriorityQueue;

public class Q1642_furthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int need = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                queue.add(heights[i] - heights[i - 1]);

                if (queue.size() > ladders) {
                    need += queue.poll();

                    if (need > bricks) {
                        return i - 1;
                    }
                }
            }
        }

        return heights.length - 1;
    }
}
