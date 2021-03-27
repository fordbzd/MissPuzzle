package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q719_Test {
    @Test
    public void testcase1() {
        int[] nums = {1, 3, 1};

        int result = new Q719_SmallestDistancePair().smallestDistancePair(nums, 1);

        assertEquals(0, result);
    }

    @Test
    public void testcase2() {
        int[] nums = {1, 6, 1};

        int result = new Q719_SmallestDistancePair().smallestDistancePair(nums, 2);

        assertEquals(5, result);
    }

    @Test
    public void testcase3() {
        int[] nums = {4, 62, 100};

        int result = new Q719_SmallestDistancePair().smallestDistancePair(nums, 2);

        assertEquals(58, result);
    }
}
