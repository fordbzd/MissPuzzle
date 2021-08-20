package org.misspuzzle.puzzle.leetcode.p1300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1383_Test {
    @Test
    public void testcase() {

        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};

        int result = new Q1383_MaxPerformance().maxPerformance(6, speed, efficiency, 2);

        assertEquals(60, result);
    }
}
