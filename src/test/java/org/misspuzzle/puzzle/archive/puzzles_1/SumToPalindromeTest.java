package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumToPalindromeTest {
	@Test
	public void testcase() {
		final int result = new SumToPalindrome().getSteps(15);

		assertEquals(1, result);
	}
}
