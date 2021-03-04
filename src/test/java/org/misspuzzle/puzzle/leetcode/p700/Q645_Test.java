package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q645_Test {
    @Test
    public void testcase() {

        int[] nums = {1, 2, 2, 4};

        int[] result = new Q645_FindErrorNums().findErrorNums(nums);

        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
    }

}
