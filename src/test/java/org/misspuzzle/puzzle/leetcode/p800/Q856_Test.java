package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q856_Test {

    @Test
    public void testcase() {

        int result = new Q856_ScoreOfParentheses().scoreOfParentheses("(()(()))");

        assertEquals(6, result);
    }


}
