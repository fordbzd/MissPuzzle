package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q936_Test {
    @Test
    public void testcase() {
        int[] result = new Q936_MovesToStamp().movesToStamp("abc", "ababc");

        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
    }
}
