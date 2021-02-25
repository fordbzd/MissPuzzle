package org.misspuzzle.puzzle.leetcode.p900;

import java.util.Stack;

public class Q856_ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.add(0);
            } else {
                int pop = stack.pop();
                int current = 0;

                while (pop != 0) {
                    current += pop;
                    pop = stack.pop();
                }

                stack.add(current == 0 ? 1 : current * 2);
            }
        }

        int sum = 0;

        do {
            sum += stack.pop();
        } while (!stack.isEmpty());

        return sum;
    }
}
