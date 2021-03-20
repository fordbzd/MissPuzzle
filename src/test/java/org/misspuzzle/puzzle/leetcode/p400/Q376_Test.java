package org.misspuzzle.puzzle.leetcode.p400;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q376_Test {
    @Test
    public void testcase1() {
        int[] nums = {1, 7, 4, 9, 2, 5};

        int result = new Q376_WiggleMaxLength().wiggleMaxLength(nums);

        assertEquals(6, result);
    }

    @Test
    public void testcase2() {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};

        int result = new Q376_WiggleMaxLength().wiggleMaxLength(nums);

        assertEquals(7, result);
    }
}
