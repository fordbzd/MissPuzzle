package org.misspuzzle.puzzle.leetcode.p000;

public class Q97_IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }

        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            boolean[] dp2 = new boolean[s2.length() + 1];
            dp2[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));

            for (int j = 1; j <= s2.length(); j++) {
                dp2[j] = (dp2[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                        || dp[j] && s1.charAt(i - 1) == s3.charAt(i + j -1));
            }

            dp = dp2;
        }

        return dp[s2.length()];
    }
}
