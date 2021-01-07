package org.misspuzzle.puzzle.amazon;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindAnagramsTest {

	@Test
	public void testcase() {
		final List<Integer> result = new FindAnagrams().findAnagrams("cbaebabacd", "abc");

		assertEquals(0, result.get(0).intValue());
		assertEquals(6, result.get(1).intValue());
	}
}
