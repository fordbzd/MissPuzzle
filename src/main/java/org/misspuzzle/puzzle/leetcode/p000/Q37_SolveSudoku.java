package org.misspuzzle.puzzle.leetcode.p000;

public class Q37_SolveSudoku {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];

        boolean[][][] cubes = new boolean[3][3][10];

        int[][] input = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = input[i][j] = board[i][j] == '.' ? 0 : (board[i][j] - '0');

                rows[i][num] = true;
                cols[j][num] = true;
                cubes[i / 3][j / 3][num] = true;
            }
        }

        dfs(input, board, rows, cols, cubes, 0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char) (input[i][j] + '0');
            }
        }
    }

    private boolean dfs(int[][] input, char[][]board, boolean[][] rows, boolean[][] cols, boolean[][][] cubes, int i, int j) {
        if (i == 9) {
            return true;
        }

        int i2 = j == 8 ? (i + 1) : i;
        int j2 = j == 8 ? 0 : (j + 1);

        if (board[i][j] != '.') {
            return dfs(input, board, rows, cols, cubes, i2, j2);
        }

        for (int num = 1; num <= 9; num++) {
            if (rows[i][num] || cols[j][num] || cubes[i / 3][j / 3][num]) {
                continue;
            }

            input[i][j] = num;
            rows[i][num] = true;
            cols[j][num] = true;
            cubes[i / 3][j / 3][num] = true;

            boolean isDone = dfs(input, board, rows, cols, cubes, i2, j2);

            if (isDone) {
                return true;
            }

            input[i][j] = 0;
            rows[i][num] = false;
            cols[j][num] = false;
            cubes[i / 3][j / 3][num] = false;
        }

        return false;
    }
}
