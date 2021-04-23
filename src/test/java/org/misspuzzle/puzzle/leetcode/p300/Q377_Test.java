package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q377_Test {
    @Test
    public void testcase() {
        int[] nums = {1, 2, 3};

        int result = new Q377_CombinationSum4().combinationSum4(nums, 4);

        assertEquals(7, result);
    }


}
