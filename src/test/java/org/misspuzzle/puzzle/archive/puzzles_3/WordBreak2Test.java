package org.misspuzzle.puzzle.archive.puzzles_3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordBreak2Test {
	@Test
	public void testcase() {
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

		final List<String> result = new WordBreak2().wordBreak("catsanddog", wordDict);

		assertEquals("cat sand dog", result.get(0));
	}
}
