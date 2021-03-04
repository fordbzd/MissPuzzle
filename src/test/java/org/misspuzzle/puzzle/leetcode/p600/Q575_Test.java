package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q575_Test {
    @Test
    public void testcase() {
        int[] candyTypes = {6, 6, 6, 6};

        int result = new Q575_DistributeCandies().distributeCandies(candyTypes);

        assertEquals(1, result);
    }
}
