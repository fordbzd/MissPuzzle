package org.misspuzzle.puzzle.leetcode.p1300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1316_Test {
    @Test
    public void testcase() {
        final int result = new Q1316_DistinctEchoSubstrings().distinctEchoSubstrings("leetcodeleetcode");

        assertEquals(2, result);
    }
}
