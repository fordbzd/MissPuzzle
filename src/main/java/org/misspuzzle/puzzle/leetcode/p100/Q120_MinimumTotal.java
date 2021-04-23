package org.misspuzzle.puzzle.leetcode.p100;

import java.util.List;

public class Q120_MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < dp.length; i++) {

            List<Integer> list = triangle.get(i);
            dp[i] = list.get(i) + dp[i - 1];

            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);

                if (i == dp.length - 1) {
                    min = Math.min(min, dp[j]);
                }
            }

            dp[0] = list.get(0) + dp[0];
        }

        return Math.min(Math.min(dp[0], dp[dp.length - 1]), min);
    }
}
