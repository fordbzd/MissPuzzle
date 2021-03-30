package org.misspuzzle.puzzle.leetcode.p700;

import java.util.Stack;

public class Q768_MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0) {
            return 1;
        }

        Stack<Integer> cuts = new Stack<>();
        cuts.add(0);

        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i;

            // Swap forward until insert position
            while (insertIndex > 0 && arr[insertIndex] < arr[insertIndex - 1]) {
                int temp = arr[insertIndex];
                arr[insertIndex] = arr[insertIndex - 1];
                arr[insertIndex - 1] = temp;

                insertIndex--;
            }

            // Remove cuts from insert position to i
            while (cuts.size() > 0 && cuts.peek() >= insertIndex) {
                cuts.pop();
            }

            cuts.push(i);
        }

        return cuts.size();
    }
}
