package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Q200_Test {
	@Test
	public void testcase() {
		final char[][] grid = {
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' },
				{ '0', '1', '1', '0', '0' },
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' }
		};

		final int result = new Q200_NumIslands().numIslands(grid);

		assertEquals(1, result);
	}
}
