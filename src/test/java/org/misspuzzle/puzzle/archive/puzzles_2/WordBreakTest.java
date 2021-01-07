package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class WordBreakTest {
    @Test
    public void testcase() {
        String s = "aaaaaaaa";

        List<String> wordDict = Arrays.asList("aaaa", "aa", "a");

        final boolean result = new WordBreak().wordBreak(s, wordDict);

        assertTrue(result);
    }
}
