package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q583_Test {
    @Test
    public void testcase() {
        int result = new Q583_MinDistance().minDistance("sea", "eat");

        assertEquals(2, result);
    }
}
