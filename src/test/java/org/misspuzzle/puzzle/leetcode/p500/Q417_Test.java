package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q417_Test {
    @Test
    public void testcase() {
        final int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        final List<List<Integer>> result = new Q417_PacificAtlantic().pacificAtlantic(matrix);

        assertEquals(0, result.get(0).get(0).intValue());
        assertEquals(4, result.get(0).get(1).intValue());
    }
}
