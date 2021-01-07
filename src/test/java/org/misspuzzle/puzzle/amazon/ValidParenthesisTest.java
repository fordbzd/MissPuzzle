package org.misspuzzle.puzzle.amazon;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class ValidParenthesisTest {

	@Test
	public void testcase() {
		final boolean result = new ValidParenthesis().isValid("{");

		assertFalse(result);
	}
}
