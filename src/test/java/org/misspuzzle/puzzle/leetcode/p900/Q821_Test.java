package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q821_Test {
    @Test
    public void testcase() {
        int[] result = new Q821_ShortestToChar().shortestToChar("loveleetcode", 'e');

        assertEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, result);
    }
}
