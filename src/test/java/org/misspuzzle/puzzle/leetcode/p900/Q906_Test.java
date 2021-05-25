package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q906_Test {
    @Test
    public void testcase() {
        int result = new Q906_SuperpalindromesInRange().superpalindromesInRange("4", "1000");

        assertEquals(4, result);
    }
}
