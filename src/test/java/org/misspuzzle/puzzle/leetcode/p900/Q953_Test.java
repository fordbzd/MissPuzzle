package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q953_Test {
    @Test
    public void testcase() {
        String[] words = {"hello","leetcode"};

        boolean result = new Q953_IsAlienSorted().isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz");

        assertTrue(result);
    }

}
