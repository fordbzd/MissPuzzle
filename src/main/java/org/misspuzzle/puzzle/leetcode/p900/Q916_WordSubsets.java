package org.misspuzzle.puzzle.leetcode.p900;

import java.util.ArrayList;
import java.util.List;

public class Q916_WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] letterB = new int[26];
        List<String> result = new ArrayList<>();

        for (String word : B) {
            int[] letters = getLetters(word);

            for (int i = 0; i < 26; i++) {
                letterB[i] = Math.max(letterB[i], letters[i]);
            }
        }

        for (String word : A) {
            int[] letters = getLetters(word);
            boolean isSub = true;

            for (int i = 0; i < 26; i++) {
                if (letters[i] < letterB[i]) {
                    isSub = false;
                    break;
                }
            }

            if (isSub) {
                result.add(word);
            }
        }

        return result;
    }

    private int[] getLetters(String word) {
        int[] letters = new int[26];

        for (char c : word.toCharArray()) {
            letters[c - 'a']++;
        }

        return letters;
    }
}
