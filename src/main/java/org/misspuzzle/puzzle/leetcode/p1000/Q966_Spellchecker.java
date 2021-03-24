package org.misspuzzle.puzzle.leetcode.p1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q966_Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();

        for (String w : wordlist) {
            String lower = w.toLowerCase();

            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(lower.replaceAll("[aeiou]", "#"), w);
        }

        for (int i = 0; i < queries.length; ++i) {
            if (words.contains(queries[i])) {
                continue;
            }

            String lower = queries[i].toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");

            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}
