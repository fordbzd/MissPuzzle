package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q336_Test {
    @Test
    public void testcase1() {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};

        List<List<Integer>> result = new Q336_PalindromePairs().palindromePairs(words);

        assertEquals(4, result.size());
    }

    @Test
    public void testcase2() {
        String[] words = {"a", ""};

        List<List<Integer>> result = new Q336_PalindromePairs().palindromePairs(words);

        assertEquals(2, result.size());
    }

    @Test
    public void testcase3() {
        String[] words = {"a", "b", "c", "ab", "ac", "aa"};

        List<List<Integer>> result = new Q336_PalindromePairs().palindromePairs(words);

        assertEquals(6, result.size());
    }
}
