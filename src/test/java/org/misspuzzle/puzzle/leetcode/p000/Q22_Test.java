package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q22_Test {
    @Test
    public void testcase() {
        final List<String> result = new Q22_GenerateParenthesis().generateParenthesis(3);

        assertEquals(5, result.size());
        assertEquals("((()))", result.get(0));
        assertEquals("(()())", result.get(1));
        assertEquals("(())()", result.get(2));
        assertEquals("()(())", result.get(3));
        assertEquals("()()()", result.get(4));
    }
}
