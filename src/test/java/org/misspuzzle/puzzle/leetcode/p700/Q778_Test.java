package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q778_Test {
    @Test
    public void testcase() {
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };

        int result = new Q778_SwimInWater().swimInWater(grid);

        assertEquals(16, result);
    }
}
