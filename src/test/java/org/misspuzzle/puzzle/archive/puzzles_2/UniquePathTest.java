package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniquePathTest {
	@Test
	public void testcase() {
		final int result = new UniquePath().uniquePaths(7, 3);

		assertEquals(28, result);
	}
}
