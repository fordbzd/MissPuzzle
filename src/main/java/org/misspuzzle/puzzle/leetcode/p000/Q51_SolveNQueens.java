package org.misspuzzle.puzzle.leetcode.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q51_SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);

        int[] board = new int[n + 1];

        int row = 1;

        while (row > 0) {
            if (row > n) {
                save(result, board);
                row--;
                continue;
            }

            board[row]++;

            if (board[row] > n) {
                board[row] = 0;
                row--;
                continue;
            }

            if (isValid(board, row)) {
                row++;
            }
        }

        return result;
    }

    private void save(List<List<String>> result, int[] board) {
        List<String> candidate = new ArrayList<>(board.length - 1);

        for (int i = 1; i < board.length; i++) {
            char[] c = new char[board.length - 1];

            Arrays.fill(c, '.');
            c[board[i] - 1] = 'Q';

            candidate.add(new String(c));
        }

        result.add(candidate);
    }

    private boolean isValid(int[] board, int row) {
        for (int i = 1; i < row; i++) {
            if (board[i] == board[row] || i - board[i] == row - board[row] || i + board[i] == row + board[row]) {
                return false;
            }
        }

        return true;
    }
}