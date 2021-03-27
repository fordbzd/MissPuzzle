package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q870_Test {
    @Test
    public void testcase1() {

        int[] A = new int[]{2, 7, 11, 15};
        int[] B = new int[]{1, 10, 4, 11};

        int[] result = new Q870_AdvantageCount().advantageCount(A, B);

        assertEquals(2, result[0]);
        assertEquals(11, result[1]);
    }

    @Test
    public void testcase2() {

        int[] A = new int[]{2, 0, 4, 1, 2};
        int[] B = new int[]{1, 3, 0, 0, 2};

        int[] result = new Q870_AdvantageCount().advantageCount(A, B);

        assertEquals(2, result[0]);
        assertEquals(4, result[1]);
    }
}
