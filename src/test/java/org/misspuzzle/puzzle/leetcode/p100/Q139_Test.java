package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Q139_Test {
    @Test
    public void testcase() {
        String s = "aaaaaaaa";

        List<String> wordDict = Arrays.asList("aaaa", "aa", "a");

        final boolean result = new Q139_WordBreak().wordBreak(s, wordDict);

        assertTrue(result);
    }
}
