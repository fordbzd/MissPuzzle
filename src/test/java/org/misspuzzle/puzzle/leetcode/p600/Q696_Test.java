package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q696_Test {
    @Test
    public void testcase() {

        int result = new Q696_CountBinarySubstrings().countBinarySubstrings("00110011");

        assertEquals(6, result);
    }
}
