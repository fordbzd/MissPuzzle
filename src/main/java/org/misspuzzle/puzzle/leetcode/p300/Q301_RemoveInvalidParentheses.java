package org.misspuzzle.puzzle.leetcode.p300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        Set<String> result = new HashSet<>();

        dfs(s, result, new StringBuilder(), 0, 0, left, right);

        return new ArrayList<>(result);
    }

    private void dfs(String s, Set<String> result, StringBuilder sb, int i, int left, int invalidLeft, int invalidRight) {
        if (i == s.length()) {
            if (invalidLeft == 0 && invalidRight == 0) {
                result.add(sb.toString());
            }

            return;
        }

        char c = s.charAt(i);

        if (c == '(' && invalidLeft > 0) {
            dfs(s, result, sb, i + 1, left, invalidLeft - 1, invalidRight);
        }

        if (c == ')' && invalidRight > 0) {
            dfs(s, result, sb, i + 1, left, invalidLeft, invalidRight - 1);
        }

        if (c == '(') {
            left++;
            if (s.length() - i - 1 < left) {
                return;
            }
        } else if (c == ')') {
            if (left > 0) {
                left--;
            } else {
                return;
            }
        }

        sb.append(c);
        dfs(s, result, sb, i + 1, left, invalidLeft, invalidRight);
        sb.deleteCharAt(sb.length() - 1);
    }
}
