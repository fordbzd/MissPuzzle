package org.misspuzzle.puzzle.leetcode.dailychallange.jan2021;

import org.junit.Test;
import org.misspuzzle.puzzle.leetcode.Q1437_KLengthApart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q1437_Test {

    @Test
    public void testcase1() {

        int[] num = {1, 0, 0, 0, 1, 0, 0, 1};

        boolean result = new Q1437_KLengthApart().kLengthApart(num, 2);

        assertTrue(result);
    }

    @Test
    public void testcase2() {

        int[] num = {1, 0, 0, 1, 0, 1};

        boolean result = new Q1437_KLengthApart().kLengthApart(num, 2);

        assertFalse(result);
    }

}
