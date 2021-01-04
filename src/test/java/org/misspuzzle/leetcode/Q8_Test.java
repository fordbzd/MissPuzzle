package org.misspuzzle.leetcode;

import org.junit.Test;
import org.misspuzzle.puzzle.leetcode.Q8_AtoI;

import static org.junit.Assert.assertEquals;

public class Q8_Test {

    @Test
    public void testAtol() {
        final int result = new Q8_AtoI().myAtoi("-2147483648fdfs");

        assertEquals(result, -2147483648);
    }
}
