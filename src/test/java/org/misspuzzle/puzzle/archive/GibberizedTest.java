package org.misspuzzle.puzzle.archive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GibberizedTest {
	@Test
	public void testcase() {
		final String result = new Gibberized().gibber("aoiUe");

		assertEquals("aoiU^e^", result);
	}
}
