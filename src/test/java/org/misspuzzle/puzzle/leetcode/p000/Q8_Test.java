package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q8_Test {

    @Test
    public void testcase() {
        final int result = new Q8_AtoI().myAtoi("-2147483648fdfs");

        assertEquals(-2147483648, result);
    }
}
