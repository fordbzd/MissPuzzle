package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q5_Test {
	@Test
	public void testcase() {
		final String result = new Q5_LongestPalindrome().longestPalindrome("bb");

		assertEquals("bb", result);
	}
}
