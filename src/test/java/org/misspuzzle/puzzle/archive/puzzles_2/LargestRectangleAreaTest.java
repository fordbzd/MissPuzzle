package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LargestRectangleAreaTest {
	@Test
	public void testcase() {
		final int[] heights = {2, 1, 5, 6, 2, 3};

		final int result = new LargestRectangleArea().largestRectangleArea(heights);

		assertEquals(10, result);
	}
}
