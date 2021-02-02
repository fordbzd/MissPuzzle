package org.misspuzzle.puzzle.leetcode.dailychallange.y2021m2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q191_Test {
    @Test
    public void testcase() {
        final int result = new Q191_HammingWeight().hammingWeight(11);

        assertEquals(3, result);
    }
}
