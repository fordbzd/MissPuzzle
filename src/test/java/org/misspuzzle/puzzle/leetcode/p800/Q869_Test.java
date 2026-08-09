package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q869_Test {
    @Test
    public void testcase1() {

        boolean result = new Q869_ReorderedPowerOf2().reorderedPowerOf2(16);

        assertTrue(result);
    }

    @Test
    public void testcase2() {

        boolean result = new Q869_ReorderedPowerOf2().reorderedPowerOf2(333);

        assertFalse(result);
    }
}
