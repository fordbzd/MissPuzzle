package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q827_Test {
    @Test
    public void testcase() {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1}
        };

        int result = new Q827_LargestIsland().largestIsland(grid);

        assertEquals(5, result);

    }
}
