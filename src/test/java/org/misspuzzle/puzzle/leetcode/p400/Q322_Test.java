package org.misspuzzle.puzzle.leetcode.p400;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q322_Test {
    @Test
    public void testcase() {
        int[] nums = {1, 2, 5};

        int result = new Q322_CoinChange().coinChange(nums, 11);

        assertEquals(3, result);
    }
}
