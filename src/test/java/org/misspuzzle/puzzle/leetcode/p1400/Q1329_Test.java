package org.misspuzzle.puzzle.leetcode.p1400;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1329_Test {
    @Test
    public void testcase() {

        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };

        mat = new Q1329_DiagonalSort().diagonalSort(mat);

        assertEquals(1, mat[0][0]);
    }
}
