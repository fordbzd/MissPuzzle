package org.misspuzzle.puzzle.leetcode.p700;

public class Q775_IsIdealPermutation {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1) {
                return false;
            }
        }

        return true;
    }
}
