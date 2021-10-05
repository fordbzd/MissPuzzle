package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q301_Test {
    @Test
    public void testcase() {
        String s = "x(";

        List<String> result = new Q301_RemoveInvalidParentheses().removeInvalidParentheses(s);

        assertEquals("x", result.get(0));
    }
}
