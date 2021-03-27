package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q714_Test {
    @Test
    public void testcase() {
        int[] price = {1, 3, 2, 8, 4, 9};

        int result = new Q714_MaxProfit().maxProfit(price, 2);

        assertEquals(8, result);
    }
}
