package org.misspuzzle.puzzle.leetcode.p1200;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1293_Test {
    @Test
    public void testcase() {

        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        int result = new Q1293_ShortestPath().shortestPath(grid, 1);

        assertEquals(6, result);
    }
}
