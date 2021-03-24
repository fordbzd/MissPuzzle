package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q923_Test {
    @Test
    public void testcase() {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

        int result = new Q923_ThreeSumMulti().threeSumMulti(arr, 8);

        assertEquals(20, result);
    }
}
