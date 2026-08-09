package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Q215_Test {
	@Test
	public void testcase() {
		final int result = new Q215_FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3);

		assertEquals(4, result);
	}
}
