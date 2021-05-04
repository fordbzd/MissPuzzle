package org.misspuzzle.puzzle.leetcode.p600;

public class Q696_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int count = 0;

        int a = 0;
        int b = 0;
        char current = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (c == current) {
                a++;
            } else {
                count += Math.min(a, b);

                b = a;
                a = 1;
                current = c;
            }
        }

        return count + Math.min(a, b);
    }
}
