package org.misspuzzle.puzzle.amazon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BFSDistanceTest {

	@Test
	public void testcase() {
		final int[] test = {7, 4, 1, 8, 10, 6, 9, 5};

		final int result = new BFSDistance().bstDistance(test, 8, 1, 19);

		assertEquals(-1, result);
	}
}