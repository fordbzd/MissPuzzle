package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q238_Test {
	@Test
	public void testcase() {
		final int[] result = new Q238_ProductExceptSelf().productExceptSelf(new int[]{1, 2 ,3, 4});

		assertEquals(24, result[0]);
	}
}
