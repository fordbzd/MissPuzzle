package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q795_Test {
    @Test
    public void testcase() {
        int[] A = new int[]{2, 1, 4, 3};

        int result = new Q795_NumSubarrayBoundedMax().numSubarrayBoundedMax(A, 2, 3);

        assertEquals(3, result);
    }
}
