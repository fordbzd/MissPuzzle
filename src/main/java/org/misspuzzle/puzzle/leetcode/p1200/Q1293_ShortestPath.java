package org.misspuzzle.puzzle.leetcode.p1200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q1293_ShortestPath {
    public int shortestPath(int[][] grid, int k) {

        int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int row = grid.length;
        int col = grid[0].length;

        int[][] visited = new int[row][col];
        int kp1 = k + 1;
        for (int[] v : visited) {
            Arrays.fill(v, kp1);
        }
        visited[0][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int step = 0;

        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                int elim = visited[x][y] == kp1 ? 0 : visited[x][y];

                if (x == row - 1 && y == col - 1) {
                    return step;
                }

                for (int[] direct : directs) {
                    int newX = x + direct[0];
                    int newY = y + direct[1];

                    if (newX < 0 || newX >= row || newY < 0 || newY >= col ||
                            (grid[newX][newY] == 1 && elim + 1 > k) ||
                            visited[newX][newY] <= (elim + (grid[newX][newY] == 1 ? 1 : 0))) {
                        continue;
                    }

                    int newElim = elim + (grid[newX][newY] == 1 ? 1 : 0);
                    visited[newX][newY] = newElim;

                    queue.add(new int[]{newX, newY});
                }

            }

            step++;
        }

        return -1;
    }
}
