package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GibberizedTest {
	@Test
	public void testcase() {
		final String result = new Gibberized().gibber("aoiUe");

		assertEquals("aoiU^e^", result);
	}
}
