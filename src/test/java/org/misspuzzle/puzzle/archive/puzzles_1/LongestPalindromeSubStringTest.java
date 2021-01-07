package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromeSubStringTest {
	@Test
	public void testcase() {
		final String result = new LongestPalindromeSubString().longestPalindrome("bb");

		assertEquals("bb", result);
	}
}
