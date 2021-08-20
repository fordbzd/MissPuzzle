package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q76_Test {
    @Test
    public void testcase() {
        final String result = new Q76_MinWindow().minWindow("ADOBECODEBANC", "ABC");

        assertEquals("BANC", result);
    }
}
