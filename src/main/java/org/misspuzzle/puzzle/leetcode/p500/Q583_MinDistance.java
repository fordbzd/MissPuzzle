package org.misspuzzle.puzzle.leetcode.p500;

public class Q583_MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }

        int[] dp = new int[word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            int[] dp2 = new int[word2.length()];

            for (int j = 0; j < word2.length(); j++) {
                dp2[j] = Math.max(
                        Math.max((j > 0 ? dp2[j - 1] : 0), dp[j]),
                        (j > 0 ? dp[j - 1] : 0) + (word1.charAt(i) == word2.charAt(j) ? 1 : 0)
                );
            }

            dp = dp2;
        }

        return word1.length() + word2.length() - (dp[word2.length() - 1] << 1);
    }
}
