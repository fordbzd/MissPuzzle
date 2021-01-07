package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaTest {
	@Test
	public void testcase() {
		final int[] height = {4, 8, 6, 7, 6};

		final int result = new MaxArea().maxArea(height);

		assertEquals(18, result);
	}
}
