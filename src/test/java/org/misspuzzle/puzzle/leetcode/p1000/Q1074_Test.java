package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q1074_Test {
    @Test
    public void testcase() {

        int[][] mat = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };

        int result = new Q1074_NumSubmatrixSumTarget().numSubmatrixSumTarget(mat, 0);

        assertEquals(4, result);
    }
}
