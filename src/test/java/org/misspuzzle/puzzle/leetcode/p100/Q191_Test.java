package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q191_Test {
    @Test
    public void testcase() {
        final int result = new Q191_HammingWeight().hammingWeight(11);

        assertEquals(3, result);
    }
}
