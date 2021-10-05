package org.misspuzzle.puzzle.leetcode.p200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q282_AddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
        }

        char[] ops = new char[num.length()];
        LinkedList<Long> queue = new LinkedList<>();

        long n = 0;
        for (int i = 0; i < (nums[0] == 0 ? 1 : nums.length); i++) {
            n = n * 10 + nums[i];

            // +
            queue.add(n);
            dfs(nums, ops, target, queue, i + 1, result);
            queue.removeLast();
        }

        return result;
    }

    private void dfs(int[] nums, char[] ops, int target, LinkedList<Long> queue, int index, List<String> result) {
        if (index == nums.length) {
            long sum = 0;
            for (long num : queue) {
                sum += num;
            }

            if (sum == (long)target) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < nums.length; i++) {
                    if (ops[i] != 0) {
                        sb.append(ops[i]);
                    }
                    sb.append(nums[i]);
                }

                result.add(sb.toString());
            }

            return;
        }

        long num = 0;
        for (int i = index; i < (nums[index] == 0 ? index + 1 : nums.length); i++) {
            num = num * 10 + nums[i];

            // +
            queue.add(num);
            ops[index] = '+';
            dfs(nums, ops, target, queue, i + 1, result);
            queue.removeLast();
            ops[index] = 0;

            // -
            queue.add(-num);
            ops[index] = '-';
            dfs(nums, ops, target, queue, i + 1, result);
            queue.removeLast();
            ops[index] = 0;

            // *
            long temp = queue.removeLast();
            queue.add(temp * num);
            ops[index] = '*';
            dfs(nums, ops, target, queue, i + 1, result);
            queue.removeLast();
            queue.add(temp);
            ops[index] = 0;
        }
    }
}
