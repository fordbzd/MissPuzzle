package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q966_Test {
    @Test
    public void testcase() {

        String[] wordlist = new String[]{"KiTe", "kite", "hare", "Hare"};
        String[] queries = new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};

        String[] result = new Q966_Spellchecker().spellchecker(wordlist, queries);

        assertEquals("kite", result[0]);
        assertEquals("", result[5]);
    }
}
