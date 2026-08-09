package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q62_Test {
	@Test
	public void testcase() {
		final int result = new Q62_UniquePath().uniquePaths(7, 3);

		assertEquals(28, result);
	}
}
