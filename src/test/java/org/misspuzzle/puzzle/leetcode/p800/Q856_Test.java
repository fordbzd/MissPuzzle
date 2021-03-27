package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q856_Test {

    @Test
    public void testcase() {

        int result = new Q856_ScoreOfParentheses().scoreOfParentheses("(()(()))");

        assertEquals(6, result);
    }


}
