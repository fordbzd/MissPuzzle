package org.misspuzzle.puzzle.leetcode.p1700;

import java.util.HashSet;
import java.util.Set;

public class Q1704_HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        return countvowels(s.substring(0, s.length() / 2), vowels) ==
                countvowels(s.substring(s.length() / 2), vowels);
    }

    private int countvowels(String s, Set<Character> vowels) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
