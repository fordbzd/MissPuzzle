package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PhoneNumberCombinationTest {
	@Test
	public void testcase() {
		final List<String> result = new PhoneNumberCombination().letterCombinations("23");

		assertEquals(9, result.size());
	}
}
