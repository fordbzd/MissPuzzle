package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q991_Test {
    @Test
    public void testcase() {

        int result = new Q991_BrokenCalc().brokenCalc(2, 3);

        assertEquals(2, result);
    }
}
