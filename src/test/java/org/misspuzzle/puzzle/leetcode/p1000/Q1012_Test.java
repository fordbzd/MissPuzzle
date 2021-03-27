package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1012_Test {
    @Test
    public void testcase() {
        int result = new Q1012_NumDupDigitsAtMostN().numDupDigitsAtMostN(1000);

        assertEquals(262, result);
    }
}
