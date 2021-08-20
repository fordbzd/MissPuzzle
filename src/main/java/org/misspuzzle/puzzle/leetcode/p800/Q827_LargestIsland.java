package org.misspuzzle.puzzle.leetcode.p800;

import java.util.HashSet;
import java.util.Set;

public class Q827_LargestIsland {
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] direct = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        Island[][] visited = new Island[row][col];

        int result = 0;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && visited[i][j] == null) {
                    max = dfsMax(i, j, grid, direct, visited);
                    result = Math.max(result, max);

                    dfsSet(i, j, grid, direct, visited, i + "_" + j, max);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int area = 0;
                    Set<String> set = new HashSet<>();

                    for (int[] d : direct) {
                        int newX = i + d[0];
                        int newY = j + d[1];

                        if (newX >= 0 && newX < row && newY >= 0 && newY < col
                            && grid[newX][newY] == 1) {
                            if (!set.contains(visited[newX][newY].id)) {
                                area += visited[newX][newY].area;
                                set.add(visited[newX][newY].id);
                            }
                        }
                    }

                    result = Math.max(result, area + 1);
                }
            }
        }

        return result;
    }

    private int dfsMax(int x, int y, int[][] grid, int[][] direct, Island[][] visited) {
        int sum = 0;
        visited[x][y] = new Island(null, 0);

        for (int[] d : direct) {
            int newX = x + d[0];
            int newY = y + d[1];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                && grid[newX][newY] == 1 && visited[newX][newY] == null) {

                sum += dfsMax(newX, newY, grid, direct, visited);
            }
        }

        return sum + 1;
    }

    private void dfsSet(int x, int y, int[][] grid, int[][] direct, Island[][] visited,
                        String id, int area) {
        visited[x][y].id = id;
        visited[x][y].area = area;

        for (int[] d : direct) {
            int newX = x + d[0];
            int newY = y + d[1];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                    && grid[newX][newY] == 1 && visited[newX][newY].id == null) {

                dfsSet(newX, newY, grid, direct, visited, id, area);
            }
        }
    }

    static class Island {
        String id;
        int area;

        Island(String id, int area) {
            this.id = id;
            this.area = area;
        }
    }
}
