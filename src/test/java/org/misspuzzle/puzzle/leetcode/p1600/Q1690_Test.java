package org.misspuzzle.puzzle.leetcode.p1600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1690_Test {

    @Test
    public void testcase() {

        int[] nums = new int[]{5, 3, 1, 4, 2};

        int result = new Q1690_StoneGameVII().stoneGameVII(nums);

        assertEquals(6, result);
    }
}
