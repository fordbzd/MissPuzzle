package org.misspuzzle.puzzle.leetcode.p600;

public class Q664_StrangePrinter {
    public int strangePrinter(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (char c : s.toCharArray()) {
            if (sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
            }
        }

        s = sb.toString();
        int length = s.length();

        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int dist = 1; dist < length; dist++) {
            for (int i = 0; i < length - dist; i++) {
                dp[i][i + dist] = dist + 1;

                for (int j = i; j < i + dist; j++) {
                    dp[i][i + dist] = Math.min(
                            dp[i][i + dist],
                            dp[i][j] + dp[j + 1][i + dist] + (s.charAt(i) == s.charAt(i + dist) ? -1 : 0)
                    );
                }
            }
        }

        return dp[0][length - 1];
    }
}
