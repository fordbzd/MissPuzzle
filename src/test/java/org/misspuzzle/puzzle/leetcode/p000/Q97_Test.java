package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
