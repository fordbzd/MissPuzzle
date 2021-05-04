package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q960_Test {
    @Test
    public void testcase() {
        String[] words = {"babca","bbazb"};

        int result = new Q960_MinDeletionSize().minDeletionSize(words);

        assertEquals(3, result);
    }
}
