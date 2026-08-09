package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q1091_Test {

    @Test
    public void testcase() {

        int[][] mat = {
                {0, 0, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 0, 0}
        };

        int result = new Q1091_ShortestPathBinaryMatrix().shortestPathBinaryMatrix(mat);

        assertEquals(4, result);
    }

}
