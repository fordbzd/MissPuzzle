package org.misspuzzle.puzzle.leetcode.p000;

import java.util.HashMap;
import java.util.Map;

public class Q13_RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = 0;
        int pre = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int num = romanMap.get(s.charAt(i));

            if (num < pre) {
                sum -= num;
            } else {
                sum += num;
            }

            pre = num;
        }

        return sum;
    }
}
