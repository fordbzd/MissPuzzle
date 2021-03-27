package org.misspuzzle.puzzle.leetcode.p800;

import java.util.Arrays;

public class Q870_AdvantageCount {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 1; i++) {
            int index = binarySearch(i, A.length - 1, A, B[i]);
            if (index == -1) {
                continue;
            }

            int num = A[index];

            while (index > i) {
                A[index] = A[index - 1];
                index--;
            }

            A[i] = num;
        }

        return A;
    }

    private int binarySearch(int start, int end, int[] A, int target) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (A[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return (start == A.length - 1 && A[start] <= target) ? -1 : start;
    }
}
