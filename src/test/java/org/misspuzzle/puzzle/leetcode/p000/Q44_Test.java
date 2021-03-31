package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q44_Test {

    @Test
    public void testcase() {
        final boolean result = new Q44_IsMatch().isMatch("abcdef", "a*d?f");

        assertTrue(result);
    }
}
