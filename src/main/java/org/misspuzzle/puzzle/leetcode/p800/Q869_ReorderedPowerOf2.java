package org.misspuzzle.puzzle.leetcode.p800;

import java.util.HashSet;
import java.util.Set;

public class Q869_ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        int[] digits = new int[10];
        Set<Integer> cache = new HashSet<>();
        int length = 0;

        while (N > 0) {
            digits[N % 10]++;
            N /= 10;
            length++;
        }

        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > 0) {
                digits[i]--;
                if (dfs(digits, cache, length - 1, i)) {
                    return true;
                }
                digits[i]++;
            }
        }

        return false;
    }

    private boolean dfs(int[] digits, Set<Integer> cache, int length, int num) {
        if (length == 0) {
            if (cache.contains(num)) {
                return false;
            }

            cache.add(num);
            return isPowerOf2(num);
        }

        num *= 10;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0) {
                digits[i]--;
                if (dfs(digits, cache, length - 1, num + i)) {
                    return true;
                }
                digits[i]++;
            }
        }

        return false;
    }

    private boolean isPowerOf2(int num) {
        while (num > 1) {
            if ((num & 1) == 1) {
                return false;
            }

            num = num >> 1;
        }

        return true;
    }
}
