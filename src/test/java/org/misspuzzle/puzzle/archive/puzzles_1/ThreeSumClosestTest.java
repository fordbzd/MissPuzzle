package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeSumClosestTest {
	@Test
	public void testcase() {
		final int[] s = {-1, 0, 1, 2, -1, -4};

		final int result = new ThreeSumClosest().threeSumClosest(s, 1);

		assertEquals(1, result);
	}
}
