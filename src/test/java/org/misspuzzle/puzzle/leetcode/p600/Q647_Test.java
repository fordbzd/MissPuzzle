package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q647_Test {
    @Test
    public void testcase() {

        int result = new Q647_CountSubstrings().countSubstrings("abcaaa");

        assertEquals(9, result);
    }
}
