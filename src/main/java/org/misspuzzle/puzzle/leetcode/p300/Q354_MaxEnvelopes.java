package org.misspuzzle.puzzle.leetcode.p300;

import java.util.Arrays;
import java.util.Comparator;

public class Q354_MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));

        int max = 1;
        int[] result = new int[envelopes.length];
        result[0] = 1;

        for (int i = 1; i < envelopes.length; i++) {
            result[i] = 1;

            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }

            max = Math.max(max, result[i]);
        }

        return max;
    }
}
