package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NumIslandsTest {
	@Test
	public void testcase() {
		final char[][] grid = {
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' },
				{ '0', '1', '1', '0', '0' },
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' }
		};

		final int result = new NumIslands().numIslands(grid);

		assertEquals(1, result);
	}
}
