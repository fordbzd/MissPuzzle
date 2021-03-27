package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q17_Test {
	@Test
	public void testcase() {
		final List<String> result = new Q17_LetterCombinations().letterCombinations("23");

		assertEquals(9, result.size());
	}
}
