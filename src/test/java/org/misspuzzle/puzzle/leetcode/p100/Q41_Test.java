package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q41_Test {
    @Test
    public void testcase1() {
        final int[] nums = {1, 2, 0};

        final int result = new Q41_FirstMissingPositive().firstMissingPositive(nums);

        assertEquals(3, result);
    }

    @Test
    public void testcase2() {
        final int[] nums = {3, 4, -1, 1};

        final int result = new Q41_FirstMissingPositive().firstMissingPositive(nums);

        assertEquals(2, result);
    }

    @Test
    public void testcase3() {
        final int[] nums = {7, 8, 9, 11, 12};

        final int result = new Q41_FirstMissingPositive().firstMissingPositive(nums);

        assertEquals(1, result);
    }

    @Test
    public void testcase4() {
        final int[] nums = {1, 2, 3};

        final int result = new Q41_FirstMissingPositive().firstMissingPositive(nums);

        assertEquals(4, result);
    }

    @Test
    public void testcase5() {
        final int[] nums = {1, 1};

        final int result = new Q41_FirstMissingPositive().firstMissingPositive(nums);

        assertEquals(2, result);
    }
}
