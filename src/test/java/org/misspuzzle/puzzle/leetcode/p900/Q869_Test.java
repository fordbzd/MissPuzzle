package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
