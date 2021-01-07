package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProfit2Test {
	@Test
	public void testcase() {
		final int result = new MaxProfit2().maxProfit(new int[]{7, 1, 5, 3, 6, 4});

		assertEquals(7, result);
	}
}
