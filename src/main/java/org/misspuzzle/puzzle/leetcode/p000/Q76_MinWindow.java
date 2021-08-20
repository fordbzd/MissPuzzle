package org.misspuzzle.puzzle.leetcode.p000;

public class Q76_MinWindow {
    public String minWindow(String s, String t) {
        int[] charT = new int[128];
        int[] charS = new int[128];
        int count = t.length();

        for (int i = 0; i < count; i++) {
            charT[t.charAt(i)]++;
        }

        int i = 0;
        int j = 0;

        int left = 0;
        int right = s.length();

        while (j < s.length() || count == 0) {
            if (count > 0) {
                int index = s.charAt(j);

                if (charS[index] < charT[index]) {
                    count--;
                }

                charS[index]++;
                j++;
            } else {
                if (j - i < right - left) {
                    left = i;
                    right = j;
                }

                int index = s.charAt(i);

                if (charT[index] > 0 && charS[index] <= charT[index]) {
                    count++;
                }

                charS[index]--;
                i++;
            }
        }

        return s.substring(left, right);
    }
}
