package org.misspuzzle.puzzle.amz;

import org.junit.jupiter.api.Test;
// import unnecessary in same package
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidParenthesisTest {

	@Test
	public void testcase() {
		final boolean result = new ValidParenthesis().isValid("{");

		assertFalse(result);
	}
}
