package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q242_Test {
    @Test
    public void testcase1() {
        final boolean result = new Q242_IsAnagram().isAnagram("abcc", "cbca");

        assertTrue(result);
    }

    @Test
    public void testcase2() {
        final boolean result = new Q242_IsAnagram().isAnagram("abcc", "ceca");

        assertFalse(result);
    }
}
