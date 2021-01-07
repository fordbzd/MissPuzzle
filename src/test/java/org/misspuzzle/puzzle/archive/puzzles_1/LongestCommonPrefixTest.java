package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {
	@Test
	public void testcase() {
		final String[] strs = { "abeee", "abeee", "abeec" };
		final String result = new LongestCommonPrefix().longestCommonPrefix(strs);

		assertEquals("abee", result);
	}
}
