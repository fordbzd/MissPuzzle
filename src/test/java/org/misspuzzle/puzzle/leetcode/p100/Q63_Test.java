package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q63_Test {
	@Test
	public void testcase() {
		int[][] obstacleGrid = {
				{0, 0, 0},
				{1, 1, 0},
				{0, 0, 0}
		};

		final int result = new Q63_UniquePath2().uniquePathsWithObstacles(obstacleGrid);

		assertEquals(1, result);
	}
}
