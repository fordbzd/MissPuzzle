package org.misspuzzle.puzzle.leetcode.p200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212_FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        buildTrie(root, words);

        Set<String> result = new HashSet<>();
        int[][] directs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, root, result, i, j, directs);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][]board, Trie node, Set<String> result, int x, int y, int[][] directs) {
        node = node.children[board[x][y] - 'a'];

        if (node.word != null) {
            result.add(node.word);
        }

        char temp = board[x][y];
        board[x][y] = '#';

        for (int[] direct : directs) {
            int newX = x + direct[0];
            int newY = y + direct[1];

            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length &&
                    board[newX][newY] != '#' && node.children[board[newX][newY] - 'a'] != null) {

                dfs(board, node, result, newX, newY, directs);
            }
        }

        board[x][y] = temp;
    }

    private void buildTrie(Trie root, String[] words) {
        for (String word : words) {
            Trie node = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }

                node = node.children[index];
            }

            node.word = word;
        }
    }

    static class Trie {
        Trie[] children;
        String word;

        Trie() {
            children = new Trie[26];
        }
    }
}
