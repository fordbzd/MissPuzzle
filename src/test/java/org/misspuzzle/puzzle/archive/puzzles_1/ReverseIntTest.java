package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntTest {
	@Test
	public void testcase() {
		final int result = new ReverseInt().reverse(-2147483648);

		assertEquals(0, result);
	}
}
