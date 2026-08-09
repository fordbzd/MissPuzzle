package org.misspuzzle.puzzle.amz;

import org.junit.jupiter.api.Test;
// import unnecessary in same package
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballScoreTest {

	@Test
	public void testcase() {
		final String[] input = {"5", "-2", "4", "Z", "X", "9", "+", "+"};

		final int result = new BaseballScore().baseBallScore(input);

		assertEquals(27, result);
	}
}
