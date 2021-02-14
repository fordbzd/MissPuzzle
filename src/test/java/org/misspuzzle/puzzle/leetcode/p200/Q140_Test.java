package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q140_Test {
	@Test
	public void testcase1() {
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

		final List<String> result = new Q140_WordBreak2().wordBreak("catsanddog", wordDict);

		assertEquals("cats and dog", result.get(0));
	}

	@Test
	public void testcase2() {
		List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
		String input = "aaaaaaaaaaaaaaaaaaaaa";

		final List<String> result = new Q140_WordBreak2().wordBreak(input, wordDict);

		assertEquals(1042432, result.size());
	}
}
