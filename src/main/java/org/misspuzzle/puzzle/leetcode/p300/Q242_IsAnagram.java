package org.misspuzzle.puzzle.leetcode.p300;

public class Q242_IsAnagram {

    public boolean isAnagram(String s, String t) {
        int[] m1 = getLetterMap(s);
        int[] m2 = getLetterMap(t);

        for (int i = 0; i < m1.length; i++) {
            if (m1[i] != m2[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getLetterMap(String s) {
        int[] map = new int[26];

        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        return map;
    }

}
