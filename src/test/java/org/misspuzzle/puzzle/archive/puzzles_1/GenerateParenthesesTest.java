package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenerateParenthesesTest {
    @Test
    public void testcase() {
        final List<String> result = new GenerateParentheses().generateParenthesis(3);

        assertEquals(5, result.size());
        assertEquals("((()))", result.get(0));
        assertEquals("(()())", result.get(1));
        assertEquals("(())()", result.get(2));
        assertEquals("()(())", result.get(3));
        assertEquals("()()()", result.get(4));
    }
}
