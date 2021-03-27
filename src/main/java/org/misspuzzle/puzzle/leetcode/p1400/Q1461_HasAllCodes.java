package org.misspuzzle.puzzle.leetcode.p1400;

import java.util.HashSet;
import java.util.Set;

public class Q1461_HasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k && set.size() < (1 << k); i++) {
            set.add(s.substring(i, i + k));
        }

        return set.size() == (1 << k);
    }
}
