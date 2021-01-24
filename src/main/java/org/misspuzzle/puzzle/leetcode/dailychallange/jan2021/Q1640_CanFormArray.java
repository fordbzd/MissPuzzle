package org.misspuzzle.puzzle.leetcode.dailychallange.jan2021;

public class Q1640_CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {

        int arrIndex = 0;
        boolean hasMatch;

        do {
            hasMatch = false;

            for (int[] piece : pieces) {
                if (arr[arrIndex] == piece[0]) {
                    hasMatch = true;
                    arrIndex++;

                    for (int j = 1; j < piece.length; j++) {
                        if (arr[arrIndex] != piece[j]) {
                            return false;
                        }

                        arrIndex++;
                    }

                    if (arrIndex >= arr.length) {
                        return true;
                    }
                }
            }
        } while (hasMatch);

        return false;
    }
}
