package org.misspuzzle.puzzle.leetcode.p400;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q474_Test {
    @Test
    public void testcase() {

        final String[] strs = {"10", "0001", "111001", "1", "0"};

        final int result = new Q474_FindMaxForm().findMaxForm(strs, 5, 3);

        assertEquals(4, result);
    }
}
