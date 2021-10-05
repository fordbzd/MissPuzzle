package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q834_Test {
    @Test
    public void testcase() {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4},
                {2, 5}
        };

        int[] result = new Q834_SumOfDistancesInTree().sumOfDistancesInTree(6, edges);

        assertEquals(8, result[0]);

    }
}
