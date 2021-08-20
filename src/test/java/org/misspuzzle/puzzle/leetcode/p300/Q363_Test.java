package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q363_Test {
    @Test
    public void testcase() {
        int[][] matrix = {
                {5, -4, -3, 4},
                {-3, -4, 4, 5},
                {5, 1, 5, -4}
        };

        int result = new Q363_MaxSumSubmatrix().maxSumSubmatrix(matrix, 3);

        assertEquals(2, result);
    }
}
