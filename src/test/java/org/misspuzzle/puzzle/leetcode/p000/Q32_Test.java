package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q32_Test {
    @Test
    public void testcase1() {
        final int result = new Q32_LongestValidParentheses().longestValidParentheses("()(())");

        assertEquals(6, result);
    }

    @Test
    public void testcase2() {
        final int result = new Q32_LongestValidParentheses().longestValidParentheses_DP("()(())");

        assertEquals(6, result);
    }
}
