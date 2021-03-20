package org.misspuzzle.puzzle.leetcode.p1400;

import java.util.LinkedList;
import java.util.Queue;

public class Q1368_MinCost {
    public int minCost(int[][] grid) {
        Queue<Coord> queue = new LinkedList<>();

        dfs(grid, queue, 0, 0);

        int step = 0;

        while(queue.size() > 0) {
            Queue<Coord> queue2 = new LinkedList<>();

            while (queue.size() > 0) {
                Coord c = queue.poll();

                if (c.x == grid.length - 1 && c.y == grid[0].length - 1) {
                    return step;
                }

                if (c.x + 1 < grid.length && grid[c.x + 1][c.y] != -1) {
                    dfs(grid, queue2, c.x + 1, c.y);
                }
                if (c.x - 1 >= 0 && grid[c.x - 1][c.y] != -1) {
                    dfs(grid, queue2, c.x - 1, c.y);
                }
                if (c.y + 1 < grid[0].length && grid[c.x][c.y + 1] != -1) {
                    dfs(grid, queue2, c.x, c.y + 1);
                }
                if (c.y - 1 >= 0 && grid[c.x][c.y - 1] != -1) {
                    dfs(grid, queue2, c.x, c.y - 1);
                }
            }

            step++;
            queue = queue2;
        }

        return step;
    }

    private void dfs(int[][]grid, Queue<Coord> queue, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return;
        }

        int direction = grid[x][y];
        grid[x][y] = -1;

        switch(direction) {
            case 1:
                dfs(grid, queue, x, y + 1);
                break;
            case 2:
                dfs(grid, queue, x, y - 1);
                break;
            case 3:
                dfs(grid, queue, x + 1, y);
                break;
            case 4:
                dfs(grid, queue, x - 1, y);
                break;
        }

        queue.add(new Coord(x, y));
    }

    private static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
