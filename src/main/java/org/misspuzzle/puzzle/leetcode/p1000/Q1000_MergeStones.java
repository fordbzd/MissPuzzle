package org.misspuzzle.puzzle.leetcode.p1000;

public class Q1000_MergeStones {
    public int mergeStones(int[] stones, int k) {
        int s = stones.length;

        if ((s  - 1) % (k - 1) != 0) {
            return -1;
        }

        int[][] dp = new int[s][s];

        for (int i = 1; i < s; i++) {
            stones[i] += stones[i - 1];
        }

        for (int r = k - 1; r < s; r++) {

            for (int i = 0; i < s - r; i++) {
                int j = i + r;
                dp[i][j] = Integer.MAX_VALUE;

                for (int m = i; m < j; m += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }

                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += stones[j] - (i == 0 ? 0 : stones[i - 1]);
                }
            }
        }

        return dp[0][s - 1];
    }
}
