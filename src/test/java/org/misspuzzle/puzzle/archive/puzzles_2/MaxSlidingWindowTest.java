package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MaxSlidingWindowTest {
	@Test
	public void testcase() {
		int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

		int[] result = new MaxSlidingWindow().maxSlidingWindow(nums, 3);

		assertEquals(3, result[0]);
	}
}
