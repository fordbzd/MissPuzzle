package org.misspuzzle.puzzle.leetcode.p1100;

import java.util.HashSet;
import java.util.Set;

public class Q1012_NumDupDigitsAtMostN {
    public int numDupDigitsAtMostN(int N) {

        int[] nums = String.valueOf(N).chars().map(c -> c - '0').toArray();

        int sum = 0;

        for (int i = 1; i < nums.length; i++) {
            sum += 9 * A(i - 1, 9);
        }

        sum += (nums[0] - 1) * A(nums.length - 1, 9);

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            set.add(nums[i - 1]);

            if (set.size() != i) {
                return N - sum;
            }

            int limited = nums[i];

            int less = 0;
            for (int p : set) {
                if (p < limited) {
                    less++;
                }
            }

            sum += Math.max(0, limited - less) * A(nums.length - i - 1, 10 - i - 1);
        }

        set.add(nums[nums.length - 1]);
        if (set.size() == nums.length) {
            sum++;
        }

        return N - sum;
    }

    private int A(int a, int b) {
        int sum = 1;

        while (a-- > 0) {
            sum *= (b - a);
        }

        return sum;
    }
}
