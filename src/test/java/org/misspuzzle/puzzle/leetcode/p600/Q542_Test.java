package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q542_Test {
	@Test
	public void testcase() {
		int[][] matrix = {
				{1, 1, 1, 0},
				{1, 1, 0, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 0, 1}
		};

		int[][] result = new Q542_UpdateMatrix().updateMatrix(matrix);

		assertEquals(3, result[0][0]);
	}
}
