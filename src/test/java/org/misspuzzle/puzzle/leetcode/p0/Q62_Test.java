package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q62_Test {
	@Test
	public void testcase() {
		final int result = new Q62_UniquePath().uniquePaths(7, 3);

		assertEquals(28, result);
	}
}
