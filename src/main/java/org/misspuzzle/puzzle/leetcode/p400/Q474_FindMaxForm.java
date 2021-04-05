package org.misspuzzle.puzzle.leetcode.p400;

public class Q474_FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int c0 = 0;
            int c1 = 0;

            for (char c : str.toCharArray()) {
                if (c == '0') {
                    c0++;
                } else {
                    c1++;
                }
            }

            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i - c0 >= 0 && j - c1 >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - c0][j - c1] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }
}
