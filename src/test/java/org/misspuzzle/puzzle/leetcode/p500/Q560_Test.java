package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q560_Test {
    @Test
    public void testcase() {
        int[] num = {2, 6, 4, 8, 10, 9, 15};

        int result = new Q560_SubarraySum().subarraySum(num, 10);

        assertEquals(2, result);
    }
}
