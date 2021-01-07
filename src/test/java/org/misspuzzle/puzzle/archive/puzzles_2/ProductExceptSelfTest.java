package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductExceptSelfTest {
	@Test
	public void testcase() {
		final int[] result = new ProductExceptSelf().productExceptSelf(new int[]{1, 2 ,3, 4});

		assertEquals(24, result[0]);
	}
}
