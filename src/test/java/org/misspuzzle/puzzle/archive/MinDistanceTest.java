package org.misspuzzle.puzzle.archive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinDistanceTest {
	@Test
	public void testcase() {
		final int result = new MinDistance().minDistance("b", "");

		assertEquals(1, result);
	}
}
