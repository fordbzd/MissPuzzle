package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q768_Test {
    @Test
    public void testcase() {
        int[] nums = {2,1,3,4,4};

        int result = new Q768_MaxChunksToSorted().maxChunksToSorted(nums);

        assertEquals(4, result);
    }
}
