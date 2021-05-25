package org.misspuzzle.puzzle.leetcode.p300;

public class Q304_NumMatrix {
    private int[][] matrix;

    public Q304_NumMatrix(int[][] matrix) {
        this.matrix = matrix;

        calculateSum();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col2]
                - (col1 > 0 ? matrix[row2][col1 - 1] : 0)
                - (row1 > 0 ? matrix[row1 - 1][col2] : 0)
                + (col1 > 0 && row1 > 0 ? matrix[row1 - 1][col1 - 1] : 0);
    }

    private void calculateSum() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] += (i > 0 ? matrix[i - 1][j] : 0)
                        + (j > 0 ? matrix[i][j - 1] : 0)
                        - (i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0);
            }
        }
    }
}
