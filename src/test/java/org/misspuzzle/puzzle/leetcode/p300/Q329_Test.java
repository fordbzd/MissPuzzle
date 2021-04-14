package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q329_Test {
    @Test
    public void testcase() {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        int result = new Q329_LongestIncreasingPath().longestIncreasingPath(matrix);

        assertEquals(4, result);
    }
}
