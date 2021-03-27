package org.misspuzzle.puzzle.leetcode.p400;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q413_Test {
    @Test
    public void testcase() {
        final int[] A = {1, 2, 3 ,4};

        final int result = new Q413_NumberOfArithmeticSlices().numberOfArithmeticSlices(A);

        assertEquals(3, result);
    }
}
