package org.misspuzzle.puzzle.leetcode.p900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q823_NumFactoredBinaryTrees {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> cache = new HashMap<>();

        cache.put(arr[0], 1L);

        for (int i = 1; i < arr.length; i++) {
            long sum = 1L;

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int quotient = arr[i] / arr[j];

                    if (cache.containsKey(quotient)) {
                        sum += cache.get(arr[j]) * cache.get(quotient);
                    }
                }
            }

            cache.put(arr[i], sum);
        }

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += cache.get(arr[i]);
        }

        return (int)(sum % 1000000007);
    }
}
