package org.misspuzzle.puzzle.openai;

import java.util.*;

public class InfectionSpread {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int spread(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        // Find all infected points to start
        Queue<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        // BFS to infect
        int day = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();

                infect(grid, p, queue);
            }

            day++;
        }

        return day;
    }

    private void infect(int[][] grid, Point p, Queue<Point> queue) {
        int row = grid.length;
        int col = grid[0].length;

        for (var d : direct) {
            int x = p.x + d[0];
            int y = p.y + d[0];

            if (x >= 0 && x < row && y >= 0 && y < col) {
                if (grid[x][y] == 0) {
                    grid[x][y] = 1;
                    queue.offer(new Point(x, y));
                }
            }
        }
    }
}
