package org.misspuzzle.puzzle.amz;

import org.junit.jupiter.api.Test;
// import unnecessary in same package

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSDistanceTest {

	@Test
	public void testcase() {
		final int[] test = {7, 4, 1, 8, 10, 6, 9, 5};

		final int result = new BFSDistance().bstDistance(test, 8, 1, 19);

		assertEquals(-1, result);
	}
}