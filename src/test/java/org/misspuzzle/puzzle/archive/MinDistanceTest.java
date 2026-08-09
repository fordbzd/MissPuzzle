package org.misspuzzle.puzzle.archive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinDistanceTest {
	@Test
	public void testcase() {
		final int result = new MinDistance().minDistance("b", "");

		assertEquals(1, result);
	}
}
