package org.misspuzzle.puzzle.leetcode.p100;

public class Q12_IntToRoman {
    public String intToRoman(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < decimal.length; i++) {
            int quotient = num / decimal[i];

            for (int j = 0; j < quotient; j++) {
                sb.append(roman[i]);
            }

            num = num % decimal[i];
        }

        return sb.toString();
    }
}
