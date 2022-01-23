package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q212_Test {
    @Test
    public void testcase() {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        List<String> result = new Q212_FindWords().findWords(board, words);

        assertEquals(2, result.size());
    }
}
