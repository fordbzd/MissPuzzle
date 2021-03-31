package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q14_Test {
	@Test
	public void testcase() {
		final String[] strs = { "abeee", "abeee", "abeec" };
		final String result = new Q14_LongestCommonPrefix().longestCommonPrefix(strs);

		assertEquals("abee", result);
	}
}
