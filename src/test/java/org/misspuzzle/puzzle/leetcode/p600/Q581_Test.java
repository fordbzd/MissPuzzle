package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q581_Test {
    @Test
    public void testcase() {
        int[] num = {2, 6, 4, 8, 10, 9, 15};

        int result = new Q581_FindUnsortedSubarray().findUnsortedSubarray(num);

        assertEquals(5, result);
    }
}
