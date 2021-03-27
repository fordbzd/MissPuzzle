package org.misspuzzle.puzzle.leetcode.p400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q417_PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();

        int row = matrix.length;
        if (row == 0) {
            return result;
        }

        int col = matrix[0].length;
        if (col == 0) {
            return result;
        }

        int[][] visited = new int[row][col];
        int[][] direction = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int[] d = direction[i];
                int x = point[0] + d[0];
                int y = point[1] + d[1];

                if(x >= 0 && y >= 0 && x < row && y < col && visited[x][y] == 0 &&
                        (x == 0 || y == 0 || matrix[x][y] >= matrix[point[0]][point[1]])) {
                    visited[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
        }

        queue = new LinkedList<>();

        queue.add(new int[]{row - 1, col - 1});
        visited[row - 1][col - 1] += 2;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int[] d = direction[i];
                int x = point[0] + d[0];
                int y = point[1] + d[1];

                if(x >= 0 && y >= 0 && x < row && y < col && visited[x][y] < 2 &&
                        (x == row - 1 || y == col - 1 || matrix[x][y] >= matrix[point[0]][point[1]])) {
                    visited[x][y] += 2;
                    queue.add(new int[]{x, y});
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 3) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);

                    result.add(point);
                }
            }
        }

        return result;
    }
}
