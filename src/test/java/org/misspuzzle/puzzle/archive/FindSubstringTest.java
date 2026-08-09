package org.misspuzzle.puzzle.archive;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSubstringTest {
	@Test
	public void testcase() {
		String[] words = {"word","good","best","good"};

		List<Integer> result = new FindSubstring().findSubstring("wordgoodgoodgoodbestword", words);

		assertEquals(8, result.get(0).intValue());
	}
}
