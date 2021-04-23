package org.misspuzzle.puzzle.leetcode.p1200;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1209_Test {
    @Test
    public void testcase() {

        String result = new Q1209_RemoveDuplicates().removeDuplicates("pbbcggttciiippooaais", 2);

        assertEquals("ps", result);
    }
}
