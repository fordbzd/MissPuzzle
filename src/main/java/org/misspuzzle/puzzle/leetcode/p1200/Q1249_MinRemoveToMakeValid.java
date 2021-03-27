package org.misspuzzle.puzzle.leetcode.p1200;

public class Q1249_MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();

        int count = 0;

        // Check left to right.
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else if (chars[i] == ')') {
                if (count > 0) {
                    count--;
                } else {
                    chars[i] = '.';
                }
            }
        }

        // Check right to left.
        count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')') {
                count++;
            } else if (chars[i] == '(') {
                if (count > 0) {
                    count--;
                } else {
                    chars[i] = '.';
                }
            }
        }

        return new String(chars).replace(".", "");
    }
}
