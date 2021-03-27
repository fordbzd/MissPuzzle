package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q785_Test {
    @Test
    public void testcase1() {
        int[][] graph = new int[][] {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        boolean result = new Q785_IsBipartite().isBipartite(graph);

        assertTrue(result);
    }

    @Test
    public void testcase2() {
        int[][] graph = new int[][] {
                {1, 2, 3},
                {0, 2},
                {1, 1, 3},
                {0, 2}
        };

        boolean result = new Q785_IsBipartite().isBipartite(graph);

        assertFalse(result);
    }
}
