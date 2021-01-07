package org.misspuzzle.puzzle.archive.puzzles_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FindKthLargestTest {
	@Test
	public void testcase() {
		final int result = new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3);

		assertEquals(4, result);
	}
}
