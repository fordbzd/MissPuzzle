package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q29_Test {
    @Test
    public void testcase1() {
        final int result = new Q29_Divide().divide(10, 3);

        assertEquals(3, result);
    }

    @Test
    public void testcase2() {
        final int result = new Q29_Divide().divide(2147483647, -1);

        assertEquals(-2147483647, result);
    }
}
