package org.misspuzzle.puzzle.leetcode.p1000;

import java.util.HashMap;
import java.util.Map;

public class Q1074_NumSubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int count = 0;

        for (int i = 0; i < col; i++) {
            for (int j = i; j < col; j++) {

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int preSum = 0;

                for (int k = 0; k < row; k++) {
                    preSum += (i == j) ? matrix[k][i] : matrix[k][j] - matrix[k][i];

                    count += map.getOrDefault(preSum - target, 0);

                    map.put(preSum, map.getOrDefault(preSum, 0) + 1);
                }
            }
        }

        return count;
    }
}
