package org.misspuzzle.puzzle.amazon;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PalindromicIntegerBinaryTest {

	@Test
	public void testcase() {
		final boolean result = new PalindromicIntegerBinary().isPalindromic(10);

		assertFalse(result);
	}
}
