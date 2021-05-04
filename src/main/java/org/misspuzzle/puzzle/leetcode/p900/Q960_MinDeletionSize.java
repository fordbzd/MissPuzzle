package org.misspuzzle.puzzle.leetcode.p900;

public class Q960_MinDeletionSize {
    public int minDeletionSize(String[] strs) {

        int wordLength = strs[0].length();

        int k;
        int min = wordLength - 1;
        int[] dp = new int[wordLength];
        dp[0] = 1;

        for (int i = 1; i < wordLength; i++) {
            dp[i] = 1;
            for ( int j = 0; j < i; j++) {
                int c;

                for (c = 0; c < strs.length; c++) {
                    if (strs[c].charAt(i) < strs[c].charAt(j)) {
                        break;
                    }
                }

                if (c == strs.length) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            min = Math.min(min, wordLength - dp[i]);
        }

        return min;
    }
}
