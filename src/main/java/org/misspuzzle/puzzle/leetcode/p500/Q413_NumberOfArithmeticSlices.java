package org.misspuzzle.puzzle.leetcode.p500;

public class Q413_NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int start = 0;
        int end = 0;
        int step = 0;

        while (start < A.length - 2) {
            if (A[start + 1] - A[start] == A[start + 2] - A[start + 1]) {
                step = A[start + 1] - A[start];
                end = start + 2;

                while ((end < A.length - 1) && (A[end + 1] - A[end] == step)) {
                    end++;
                }

                count += (end - start) * (end - start - 1) / 2;

                start = end;
            } else {
                start++;
            }
        }

        return count;
    }
}
