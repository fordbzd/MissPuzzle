package org.misspuzzle.puzzle.leetcode.p1300;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q1368_Test {
    @Test
    public void testcase() {

        int[][] grid = {
                {1, 1, 3},
                {3, 2, 2},
                {1, 1, 4}
        };

        int result = new Q1368_MinCost().minCost(grid);

        assertEquals(0, result);
    }
}
