package org.misspuzzle.puzzle.leetcode.p1400;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
