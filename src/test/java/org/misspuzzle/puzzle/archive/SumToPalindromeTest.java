package org.misspuzzle.puzzle.archive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumToPalindromeTest {
	@Test
	public void testcase() {
		final int result = new SumToPalindrome().getSteps(15);

		assertEquals(1, result);
	}
}
