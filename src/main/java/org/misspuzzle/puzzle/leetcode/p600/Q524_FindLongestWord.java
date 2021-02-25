package org.misspuzzle.puzzle.leetcode.p600;

import java.util.List;

public class Q524_FindLongestWord {
    public String findLongestWord(String s, List<String> d) {

        d.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        for (String word : d) {

            int index = 0;
            for (char c : s.toCharArray()) {
                if (c == word.charAt(index)) {
                    index++;

                    if (index == word.length()) {
                        return word;
                    }
                }
            }
        }

        return "";
    }
}
