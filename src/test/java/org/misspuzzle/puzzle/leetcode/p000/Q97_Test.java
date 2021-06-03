package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q97_Test {
    @Test
    public void testcase() {
        final boolean result = new Q97_IsInterleave().isInterleave(
                "aabcc",
                "dbbca",
                "aadbbcbcac"
        );

        assertTrue(result);
    }
}
