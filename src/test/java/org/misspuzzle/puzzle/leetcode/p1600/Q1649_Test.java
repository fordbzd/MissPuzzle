package org.misspuzzle.puzzle.leetcode.p1600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1649_Test {

    @Test
    public void testcase1() {
        int[] instructions = {1, 5, 6, 2};

        int result = new Q1649_CreateSortedArray().createSortedArray(instructions);

        assertEquals(1, result);
    }

    @Test
    public void testcase2() {
        int[] instructions = {1, 2, 3, 6, 5, 4};

        int result = new Q1649_CreateSortedArray().createSortedArray(instructions);

        assertEquals(3, result);
    }

    @Test
    public void testcase3() {
        int[] instructions = {1, 3, 3, 3, 2, 4, 2, 1, 2};

        int result = new Q1649_CreateSortedArray().createSortedArray(instructions);

        assertEquals(4, result);
    }

    @Test
    public void testcase4() {
        int[] instructions = {3, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1};

        int result = new Q1649_CreateSortedArray().createSortedArray(instructions);

        assertEquals(28, result);
    }
}
