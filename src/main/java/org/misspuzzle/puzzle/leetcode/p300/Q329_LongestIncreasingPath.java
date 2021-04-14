package org.misspuzzle.puzzle.leetcode.p300;

public class Q329_LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] direction = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        int[][] path = new int[matrix.length][matrix[0].length];

        int longest = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longest = Math.max(longest, dfs(i, j, matrix, direction, path));
            }
        }

        return longest;
    }

    private int dfs(int x, int y, int[][] matrix, int[][] direction, int[][] path) {
        if (path[x][y] > 0) {
            return path[x][y];
        }

        int longest = 0;

        for (int[] ints : direction) {
            int newX = x + ints[0];
            int newY = y + ints[1];

            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[x][y] < matrix[newX][newY]) {
                longest = Math.max(longest, dfs(newX, newY, matrix, direction, path));
            }
        }

        longest++;
        path[x][y] = longest;

        return longest;
    }
}
