package org.misspuzzle.puzzle.leetcode.p1300;

import java.util.HashSet;
import java.util.Set;

public class Q1316_DistinctEchoSubstrings {
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();

        for (int l = 1; l <= text.length() / 2; l++) {
            for (int i = 0; i <= text.length() - l * 2; i++) {
                boolean isTwo = true;
                for (int j = i; j < i + l; j++) {
                    if (text.charAt(j) != text.charAt(j + l)) {
                        isTwo = false;
                        break;
                    }
                }

                if (isTwo) {
                    set.add(text.substring(i, i + l * 2));
                }
            }
        }

        return set.size();
    }
}
