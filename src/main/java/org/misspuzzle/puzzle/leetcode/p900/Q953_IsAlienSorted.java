package org.misspuzzle.puzzle.leetcode.p900;

import java.util.HashMap;
import java.util.Map;

public class Q953_IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i - 1], words[i], map)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSorted(String s1, String s2, Map<Character, Integer> map) {

        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            int o1 = map.get(s1.charAt(i));
            int o2 = map.get(s2.charAt(i));

            if (o1 < o2) {
                return true;
            } else if (o1 > o2) {
                return false;
            }
        }

        return s1.length() <= s2.length();
    }
}
