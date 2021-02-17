package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q784_Test {
    @Test
    public void testcase() {
        List<String> result = new Q784_LetterCasePermutation().letterCasePermutation("a1B2");

        assertEquals(4, result.size());
    }
}
