package org.misspuzzle.puzzle.leetcode.p900;

import org.misspuzzle.datastructure.Trie;

public class Q820_MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            root.insert(new StringBuilder(word).reverse().toString());
        }

        return dfs(root);
    }

    private int dfs(Trie root) {
        int sum = 0;

        for (Trie trie : root.getLetters().values()) {
            if (trie != null) {
                sum += dfs(trie);
            }
        }

        if (sum == 0) {
            return root.getWord() != null ? root.getWord().length() + 1 : 0;
        } else {
            return sum;
        }
    }
}
