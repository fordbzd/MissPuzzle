package org.misspuzzle.puzzle.leetcode.p000;

import java.util.Stack;

public class Q32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }

        int max = 0;
        int end = s.length();
        while (!stack.isEmpty()) {
            int start = stack.pop();
            max = Math.max(max, end - start - 1);

            end = start;
        }

        return Math.max(max, end);
    }

    public int longestValidParentheses_DP(String s) {
        int max = 0;

        int[] longest = new int[s.length()];

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')' && (i - longest[i - 1] - 1) >= 0 && s.charAt(i - longest[i - 1] - 1) == '('){
                longest[i] = longest[i - 1] + 2 +
                        ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);

                max = Math.max(longest[i],max);
            }
        }
        return max;
    }
}
