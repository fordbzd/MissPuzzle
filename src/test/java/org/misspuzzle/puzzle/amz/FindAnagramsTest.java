package org.misspuzzle.puzzle.amz;

import org.junit.jupiter.api.Test;
// import unnecessary in same package

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAnagramsTest {

	@Test
	public void testcase() {
		final List<Integer> result = new FindAnagrams().findAnagrams("cbaebabacd", "abc");

		assertEquals(0, result.get(0).intValue());
		assertEquals(6, result.get(1).intValue());
	}
}
