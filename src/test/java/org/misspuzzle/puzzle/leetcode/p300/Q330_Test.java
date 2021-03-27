package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q330_Test {
    @Test
    public void testcase1() {
        int[] nums = {1, 5, 10};

        int result = new Q330_MinPatches().minPatches(nums, 20);

        assertEquals(2, result);
    }

    @Test
    public void testcase2() {
        int[] nums = {1, 2, 31, 33};

        int result = new Q330_MinPatches().minPatches(nums, 2147483647);

        assertEquals(28, result);
    }


}
