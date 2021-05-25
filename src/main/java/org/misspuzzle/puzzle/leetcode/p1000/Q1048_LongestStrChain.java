package org.misspuzzle.puzzle.leetcode.p1000;

import java.util.*;

public class Q1048_LongestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> cache = new HashMap<>();
        int result = 0;

        for (String word : words) {
            int max = 0;

            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + word.substring(i + 1);
                max = Math.max(max, cache.getOrDefault(sub, 0));
            }

            cache.put(word, ++max);
            result = Math.max(result, max);
        }

        return result;
    }
}
