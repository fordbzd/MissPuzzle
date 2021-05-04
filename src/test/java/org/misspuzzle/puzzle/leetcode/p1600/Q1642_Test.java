package org.misspuzzle.puzzle.leetcode.p1600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1642_Test {
    @Test
    public void testcase() {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};

        int result = new Q1642_furthestBuilding().furthestBuilding(heights, 5, 1);

        assertEquals(4, result);
    }
}
