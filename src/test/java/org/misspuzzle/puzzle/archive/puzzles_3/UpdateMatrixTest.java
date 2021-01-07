package org.misspuzzle.puzzle.archive.puzzles_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdateMatrixTest {
	@Test
	public void testcase() {
		int[][] matrix = {
				{1, 1, 1, 0},
				{1, 1, 0, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 0, 1}
		};

		int[][] result = new UpdateMatrix().updateMatrix(matrix);

		assertEquals(3, result[0][0]);
	}
}
