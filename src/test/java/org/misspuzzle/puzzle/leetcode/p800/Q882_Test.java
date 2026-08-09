package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q882_Test {
    @Test
    public void testcase() {

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 1},
                {1, 2, 2}
        };

        int result = new Q882_ReachableNodes().reachableNodes(edges, 6, 3);

        assertEquals(13, result);
    }
}
