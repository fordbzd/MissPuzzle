package org.misspuzzle.puzzle.leetcode.dailychallange.jan2021;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

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
