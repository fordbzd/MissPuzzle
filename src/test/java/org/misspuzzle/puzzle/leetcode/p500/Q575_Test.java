package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q575_Test {
    @Test
    public void testcase() {
        int[] candyTypes = {6, 6, 6, 6};

        int result = new Q575_DistributeCandies().distributeCandies(candyTypes);

        assertEquals(1, result);
    }
}
