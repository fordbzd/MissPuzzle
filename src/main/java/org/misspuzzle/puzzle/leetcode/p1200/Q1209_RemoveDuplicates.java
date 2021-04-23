package org.misspuzzle.puzzle.leetcode.p1200;

import java.util.Stack;

public class Q1209_RemoveDuplicates {
    public String removeDuplicates(String s, int k) {
        Stack<CharCount> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().c == s.charAt(i)) {
                if (stack.peek().count == k - 1) {
                    for (int j = 0; j < k - 1; j++) {
                        stack.pop();
                    }
                } else {
                    stack.push(new CharCount(s.charAt(i), stack.peek().count + 1));
                }
            } else {
                stack.push(new CharCount(s.charAt(i), 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }


        return sb.reverse().toString();
    }

    private static class CharCount {
        char c;
        int count;
        CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
