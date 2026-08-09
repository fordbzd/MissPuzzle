package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
