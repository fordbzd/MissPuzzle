package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q5_Test {
	@Test
	public void testcase() {
		final String result = new Q5_LongestPalindrome().longestPalindrome("bb");

		assertEquals("bb", result);
	}
}
