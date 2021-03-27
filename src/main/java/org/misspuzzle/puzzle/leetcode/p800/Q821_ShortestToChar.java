package org.misspuzzle.puzzle.leetcode.p800;

public class Q821_ShortestToChar {
    public int[] shortestToChar(String s, char c) {

        int[] result = new int[s.length()];

        if (s.length() < 2) {
            return result;
        }

        result[0] = s.charAt(0) == c ? 0 : s.length();

        for (int i = 1; i < s.length(); i++) {
            result[i] = s.charAt(i) == c ? 0 : (result[i - 1] + 1);
        }

        for (int i = s.length() - 2; i > 0; i--) {
            result[i] = s.charAt(i) == c ? 0 : Math.min(result[i - 1] + 1, (result[i + 1] + 1));
        }

        result[0] = s.charAt(0) == c ? 0 : result[1] + 1;

        return result;
    }
}
