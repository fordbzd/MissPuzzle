package org.misspuzzle.puzzle.archive.puzzles_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountAndSayTest {
	@Test
	public void testcase() {
		final String result = new CountAndSay().countAndSay(6);

		assertEquals("312211", result);
	}
}
