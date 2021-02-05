package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q594_Test {

    @Test
    public void testcase() {
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};

        int result = new Q594_FindLHS().findLHS(nums);

        assertEquals(5, result);
    }
}
