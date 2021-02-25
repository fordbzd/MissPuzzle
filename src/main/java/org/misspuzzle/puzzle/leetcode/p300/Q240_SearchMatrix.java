package org.misspuzzle.puzzle.leetcode.p300;

public class Q240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int row = 0;
        int col = colLength - 1;

        while (row < rowLength && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }
}
