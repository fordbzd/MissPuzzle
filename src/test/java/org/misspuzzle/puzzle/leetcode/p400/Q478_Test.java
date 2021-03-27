package org.misspuzzle.puzzle.leetcode.p400;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q478_Test {
    @Test
    public void testcase() {
        Q478_RandPoint solution = new Q478_RandPoint(1, 0, 0);

        final double[] result = solution.randPoint();

        assertTrue(result[0] <= 1.0);
        assertTrue(result[1] <= 1.0);
    }
}
