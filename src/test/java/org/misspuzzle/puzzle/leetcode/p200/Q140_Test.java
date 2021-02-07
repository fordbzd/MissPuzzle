package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q140_Test {
	@Test
	public void testcase() {
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

		final List<String> result = new Q140_WordBreak2().wordBreak("catsanddog", wordDict);

		assertEquals("cat sand dog", result.get(0));
	}
}
