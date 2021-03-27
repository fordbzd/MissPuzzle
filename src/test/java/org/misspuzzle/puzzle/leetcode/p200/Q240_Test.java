package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q240_Test {
    @Test
    public void testcase() {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        final boolean result = new Q240_SearchMatrix().searchMatrix(matrix, 17);

        assertTrue(result);
    }
}
