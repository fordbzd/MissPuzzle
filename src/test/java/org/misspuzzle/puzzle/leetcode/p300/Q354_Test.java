package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q354_Test {
    @Test
    public void testcase() {
        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        int result = new Q354_MaxEnvelopes().maxEnvelopes(envelopes);

        assertEquals(3, result);
    }
}
