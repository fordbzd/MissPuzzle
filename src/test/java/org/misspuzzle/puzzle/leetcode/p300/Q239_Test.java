package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Q239_Test {
	@Test
	public void testcase() {
		int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

		int[] result = new Q239_MaxSlidingWindow().maxSlidingWindow(nums, 3);

		assertEquals(3, result[0]);
	}
}
