package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q304_Test {
    @Test
    public void testcase() {
        int[][] nums = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int result = new Q304_NumMatrix(nums).sumRegion(0, 0, 1, 1);

        assertEquals(4, result);
    }


}
