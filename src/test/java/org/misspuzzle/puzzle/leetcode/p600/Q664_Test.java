package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q664_Test {
    @Test
    public void testcase() {

        int result = new Q664_StrangePrinter().strangePrinter("aabccbb");

        assertEquals(3, result);
    }
}
