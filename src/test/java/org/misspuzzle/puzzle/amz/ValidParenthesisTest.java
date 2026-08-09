package org.misspuzzle.puzzle.amz;

import org.junit.Test;
import org.misspuzzle.puzzle.amz.ValidParenthesis;

import static org.junit.Assert.assertFalse;

public class ValidParenthesisTest {

	@Test
	public void testcase() {
		final boolean result = new ValidParenthesis().isValid("{");

		assertFalse(result);
	}
}
