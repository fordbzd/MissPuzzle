package org.misspuzzle.puzzle.leetcode.dailychallange.y2021m1;

import java.util.Arrays;

public class Q1329_DiagonalSort {

    public int[][] diagonalSort(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        for (int i = 0; i < row; i++) {
            int length = Math.min(row - i, col);

            int[] diag = new int[length];

            for (int j = 0; j < length; j++) {
                diag[j] = mat[i + j][j];
            }

            Arrays.sort(diag);

            for (int j = 0; j < length; j++) {
                mat[i + j][j] = diag[j];
            }
        }

        for (int j = 1; j < col; j++) {
            int length = Math.min(row, col - j);

            int[] diag = new int[length];

            for (int i = 0; i < length; i++) {
                diag[i] = mat[i][i + j];
            }

            Arrays.sort(diag);

            for (int i = 0; i < length; i++) {
                mat[i][i + j] = diag[i];
            }
        }

        return mat;
    }

}
