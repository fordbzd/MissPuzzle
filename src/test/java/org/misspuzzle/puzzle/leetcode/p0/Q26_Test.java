package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q26_Test {
	@Test
	public void testcase() {
		int[] nums = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4};

		final int result = new Q26_RemoveDuplicates().removeDuplicates(nums);

		assertEquals(4, result);
	}
}
