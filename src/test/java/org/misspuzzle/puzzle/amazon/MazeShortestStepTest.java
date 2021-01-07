package org.misspuzzle.puzzle.amazon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MazeShortestStepTest {

	@Test
	public void testcase() {
		final int[][] maze = { {0} };
		final int result = new MazeShortestStep().findShortestStep(maze, 1, 1, 0, 0);

		assertEquals(1, result);
	}

	@Test
	public void testcase2() {
		final int[][] maze = {
				{0, 1, 1, 1, 1},
				{0, 0, 0, 0, 1},
				{1, 0, 1, 0, 0},
				{1, 0, 1, 0, 1},
				{1, 0, 0, 0, 1}
		};
		final int result = new MazeShortestStep().findShortestStep(maze, 5, 5, 2, 4);

		assertEquals(7, result);
	}
}
