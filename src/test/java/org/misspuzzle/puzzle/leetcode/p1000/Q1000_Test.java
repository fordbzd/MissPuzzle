package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1000_Test {
    @Test
    public void testcase() {
        int[] stones = {3, 5, 1, 2, 6};

        int result = new Q1000_MergeStones().mergeStones(stones, 3);

        assertEquals(25, result);
    }
}
