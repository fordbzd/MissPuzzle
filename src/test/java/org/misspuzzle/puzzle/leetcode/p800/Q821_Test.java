package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Q821_Test {
    @Test
    public void testcase() {
        int[] result = new Q821_ShortestToChar().shortestToChar("loveleetcode", 'e');

        assertArrayEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, result);
    }
}
