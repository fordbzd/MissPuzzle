package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class Q139_Test {
    @Test
    public void testcase() {
        String s = "aaaaaaaa";

        List<String> wordDict = Arrays.asList("aaaa", "aa", "a");

        final boolean result = new Q139_WordBreak().wordBreak(s, wordDict);

        assertTrue(result);
    }
}
