package org.misspuzzle.puzzle.archive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProfitTest {
	@Test
	public void testcase() {
		final int result = new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4});

		assertEquals(5, result);
	}
}
