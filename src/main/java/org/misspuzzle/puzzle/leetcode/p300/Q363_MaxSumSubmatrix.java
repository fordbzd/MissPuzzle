package org.misspuzzle.puzzle.leetcode.p300;

public class Q363_MaxSumSubmatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        int row = matrix.length;
        int col = matrix[0].length;

        for (int j = 1; j < col; j++) {
            matrix[0][j] += matrix[0][j - 1];
        }

        for (int i = 1; i < row; i++) {
            matrix[i][0] += matrix[i - 1][0];

            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < row; i++) {
            for (int il = i; il < row; il++) {

                for (int j = 0; j < col; j++) {
                    for (int jl = j; jl < col; jl++) {
                        sum = matrix[il][jl]
                                - (j > 0 ? matrix[il][j - 1] : 0)
                                - (i > 0 ? matrix[i - 1][jl] : 0)
                                + (i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0);
                        if (sum <= k && sum > max) {
                            max = Math.max(max, sum);
//                            System.out.println(i + "-" + il + "," + j + "-" + jl);
                        }
                    }
                }
            }
        }

        return max;
    }
}
