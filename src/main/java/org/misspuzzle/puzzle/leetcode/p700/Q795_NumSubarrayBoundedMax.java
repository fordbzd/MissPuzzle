package org.misspuzzle.puzzle.leetcode.p700;

public class Q795_NumSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {

        int left = -1;
        int max = -1;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                left = -1;
                max = -1;
            } else if (A[i] < L) {
                if (left == -1) {
                    left = i;
                } else if (max != -1) {
                    count += max - left + 1;
                }
            } else {
                if (left == -1) {
                    left = i;
                }

                max = i;
                count += max - left + 1;
            }
        }

        return count;
    }
}
