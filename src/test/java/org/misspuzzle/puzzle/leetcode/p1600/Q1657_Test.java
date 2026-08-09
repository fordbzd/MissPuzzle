package org.misspuzzle.puzzle.leetcode.p1600;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q1657_Test {
    @Test
    public void testcase() {
        final Q1657_CloseStrings q = new Q1657_CloseStrings();

        assertTrue(q.closeStrings("abc", "bca"));
        assertFalse(q.closeStrings("a", "aa"));
        assertTrue(q.closeStrings("cabbba", "abbccc"));
        assertFalse(q.closeStrings("cabbba", "aabbss"));
        assertFalse(q.closeStrings("uau", "ssx"));
    }

}
