package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniquePath2Test {
	@Test
	public void testcase() {
		int[][] obstacleGrid = {
				{0, 0, 0},
				{1, 1, 0},
				{0, 0, 0}
		};

		final int result = new UniquePath2().uniquePathsWithObstacles(obstacleGrid);

		assertEquals(1, result);
	}
}
