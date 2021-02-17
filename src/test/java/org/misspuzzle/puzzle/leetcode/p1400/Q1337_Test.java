package org.misspuzzle.puzzle.leetcode.p1400;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1337_Test {
    @Test
    public void testcase() {

        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };

        int[] result = new Q1337_KWeakestRows().kWeakestRows(mat, 2);

        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
    }
}
