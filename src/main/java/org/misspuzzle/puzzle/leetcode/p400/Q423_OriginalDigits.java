package org.misspuzzle.puzzle.leetcode.p400;

public class Q423_OriginalDigits {
    public String originalDigits(String s) {
        int[] result = new int[10];
        int[] letters = new int[26];

        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        String[] words = {"wto", "ufor", "xis", "geiht", "zero", "one", "seven", "rthee", "vife", "inne"};
        int[] numbers = {2, 4, 6, 8, 0, 1, 7, 3, 5, 9};

        for (int i = 0; i < 10; i++) {
            String word = words[i];

            int count = letters[word.charAt(0) - 'a'];
            result[numbers[i]] += count;

            for (char c : word.toCharArray()) {
                letters[c - 'a'] -= count;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < result[i]; j++) {
                sb.append((char)(i + '0'));
            }
        }

        return sb.toString();
    }
}
