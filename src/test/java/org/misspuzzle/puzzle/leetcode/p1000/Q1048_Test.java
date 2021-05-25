package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1048_Test {
    @Test
    public void testcase() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        int result = new Q1048_LongestStrChain().longestStrChain(words);

        assertEquals(4, result);
    }
}
