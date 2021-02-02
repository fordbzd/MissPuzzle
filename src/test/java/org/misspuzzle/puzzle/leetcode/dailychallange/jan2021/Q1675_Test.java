package org.misspuzzle.puzzle.leetcode.dailychallange.jan2021;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1675_Test {
    @Test
    public void testcase1() {

        int[] nums = new int[]{1, 2, 3, 4};

        int result = new Q1675_MinimumDeviation().minimumDeviation(nums);

        assertEquals(1, result);
    }

    @Test
    public void testcase2() {

        int[] nums = new int[]{4, 1, 5, 20, 3};

        int result = new Q1675_MinimumDeviation().minimumDeviation(nums);

        assertEquals(3, result);
    }
}
