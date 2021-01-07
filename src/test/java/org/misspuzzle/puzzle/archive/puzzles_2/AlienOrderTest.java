package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlienOrderTest {
	@Test
	public void testcase() {
		final String result = new AlienOrder().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});

		assertEquals("wertf", result);
	}
}
