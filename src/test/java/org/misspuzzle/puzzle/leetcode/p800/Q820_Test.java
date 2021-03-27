package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q820_Test {
    @Test
    public void testcase() {

        String[] words = {"time", "me", "bell"};

        int result = new Q820_MinimumLengthEncoding().minimumLengthEncoding(words);

        assertEquals(10, result);
    }


}
