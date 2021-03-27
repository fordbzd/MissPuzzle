package org.misspuzzle.puzzle.leetcode.p600;

public class Q647_CountSubstrings {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] sub = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            sub[i][i] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int end = j + i;

                sub[j][end] = (j + 1 > end - 1 || sub[j + 1][end - 1]) && s.charAt(j) == s.charAt(end);
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (sub[i][j]) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
