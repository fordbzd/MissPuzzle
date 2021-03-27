package org.misspuzzle.puzzle.leetcode.p900;

import java.util.Stack;

public class Q946_ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int num : pushed) {
            if (num == popped[index]) {
                // Pushed and popped immediately.
                index++;

                while (!stack.isEmpty() && stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                }
            } else {
                stack.push(num);
            }
        }

        return stack.isEmpty() && index == popped.length;
    }
}
