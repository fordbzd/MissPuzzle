package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Q84_Test {
	@Test
	public void testcase() {
		final int[] heights = {2, 1, 5, 6, 2, 3};

		final int result = new Q84_LargestRectangleArea().largestRectangleArea(heights);

		assertEquals(10, result);
	}
}
