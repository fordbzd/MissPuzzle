package org.misspuzzle.puzzle.leetcode.p100;

public class Q44_IsMatch {
    public boolean isMatch(String s, String p) {

        boolean[] dp = new boolean[p.length() + 1];

        dp[0] = true;
        int start = 0;
        int end = 0;

        for (int j = 1; j <= p.length(); j++) {
            dp[j] = p.charAt(j - 1) == '*' && dp[j - 1];

            end = dp[j] ? j : end;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (start == -1) {
                return false;
            }

            boolean[] dp2 = new boolean[p.length() + 1];

            int start2 = -1;
            int end2 = -1;

            for (int j = Math.max(start, 1); j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp2[j] = dp[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp2[j] = dp[j] || dp2[j - 1];
                }

                start2 = (start2 == -1 && dp2[j]) ? j : start2;
                end2 = dp2[j] ? j : end2;

                if (!dp2[j] && j > end) {
                    break;
                }
            }

            dp = dp2;
            start = start2;
            end = end2;
        }

        return dp[p.length()];
    }
}
