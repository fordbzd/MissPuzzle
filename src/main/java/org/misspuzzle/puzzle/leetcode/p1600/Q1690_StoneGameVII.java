package org.misspuzzle.puzzle.leetcode.p1600;

public class Q1690_StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        int[] preSum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }

        int[] dp = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[j] = Math.max(
                        preSum[j + 1] - preSum[i + 1] - dp[j],
                        preSum[j] - preSum[i] - dp[j - 1]
                );
            }
        }

        return dp[len - 1];
    }
}
