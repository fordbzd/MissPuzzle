package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q934_Test {
    @Test
    public void testcase() {
        String[] words = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};

        String result = new Q934_ShortestSuperstring().shortestSuperstring(words);

        assertEquals("gctaagttcatgcatc", result);
    }
}
