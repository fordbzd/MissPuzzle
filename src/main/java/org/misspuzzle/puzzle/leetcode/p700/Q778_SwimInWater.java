package org.misspuzzle.puzzle.leetcode.p700;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q778_SwimInWater {
    public int swimInWater(int[][] grid) {

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        grid[0][0] = -1;

        while(pq.size() > 0) {
            int[] current = pq.poll();

            for (int[] direct : directions) {
                int newX = current[0] + direct[0];
                int newY = current[1] + direct[1];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                && grid[newX][newY] != -1) {
                    if (newX == grid.length - 1 && newY == grid[0].length - 1) {
                        return Math.max(current[2], grid[newX][newY]);
                    }

                    pq.offer(new int[]{newX, newY, Math.max(current[2], grid[newX][newY])});
                    grid[newX][newY] = -1;
                }
            }
        }

        return -1;
    }
}
