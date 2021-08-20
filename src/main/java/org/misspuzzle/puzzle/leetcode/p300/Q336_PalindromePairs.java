package org.misspuzzle.puzzle.leetcode.p300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {

        Trie root = new Trie();

        // Build Trie
        for (int i = 0; i < words.length; i++) {
            Trie node = root;
            String word = words[i];

            for (int j = word.length() - 1; j >= 0; j--) {

                if (isPalindrome(word, 0, j)) {
                    node.list.add(i);
                }

                int pos = word.charAt(j) - 'a';
                if (node.chars[pos] == null) {
                    node.chars[pos] = new Trie();
                }

                node = node.chars[pos];
            }

            node.index = i;
        }

        // Search each word in Trie
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Trie node = root;
            String word = words[i];
            boolean isComplete = true;

            for (int j = 0; j < word.length(); j++) {
                int pos = word.charAt(j) - 'a';

                if (isPalindrome(word, j, word.length() - 1) && node.index != -1) {
                    result.add(Arrays.asList(i, node.index));
                }

                if (node.chars[pos] == null) {
                    isComplete = false;
                    break;
                }

                node = node.chars[pos];
            }

            if (isComplete) {
                if (node.index != -1 && node.index != i) {
                    result.add(Arrays.asList(i, node.index));
                }

                for (int p : node.list) {
                    if (p != i) {
                        result.add(Arrays.asList(i, p));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

    static class Trie {
        Trie[] chars;
        int index;
        List<Integer> list;

        Trie() {
            index = -1;
            chars = new Trie[26];
            list = new ArrayList<>();
        }
    }
}
