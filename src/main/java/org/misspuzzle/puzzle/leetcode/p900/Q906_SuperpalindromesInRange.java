package org.misspuzzle.puzzle.leetcode.p900;

import java.util.LinkedList;
import java.util.List;

public class Q906_SuperpalindromesInRange {
    public int superpalindromesInRange(String left, String right) {
        List<Integer> list = getAllPalindromes();
        int count = 0;
        long longLeft = Long.parseLong(left);
        long longRight = Long.parseLong(right);

        for (int num : list) {
            long superNum = (long) num * num;

            if (superNum >= longLeft && superNum <= longRight && isPalindrome(String.valueOf(superNum))) {
                count++;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> getAllPalindromes() {
        List<Integer> set = new LinkedList<>();

        for (int i = 1; i < 10; i++) {
            set.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 1; i < 10000; i++) {
            String right = sb.toString();
            String left = sb.reverse().toString();

            set.add(Integer.parseInt(left + right));

            for (int j = 0; j < 10; j++) {
                set.add(Integer.parseInt(left + j + right));
            }

            sb.reverse();
            int k;
            for (k = 0; k < sb.length(); k++) {
                if (sb.charAt(k) < '9') {
                    sb.setCharAt(k, (char) (sb.charAt(k) + 1));
                    break;
                } else {
                    sb.setCharAt(k, '0');
                }
            }
            if (k == sb.length()) {
                sb.append('1');
            }
        }

        return set;
    }
}
