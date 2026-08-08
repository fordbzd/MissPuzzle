package org.misspuzzle.puzzle.amazon;

import org.junit.Test;
import org.misspuzzle.puzzle.amz.BaseballScore;

import static org.junit.Assert.assertEquals;

public class BaseballScoreTest {

	@Test
	public void testcase() {
		final String[] input = {"5", "-2", "4", "Z", "X", "9", "+", "+"};

		final int result = new BaseballScore().baseBallScore(input);

		assertEquals(27, result);
	}
}
