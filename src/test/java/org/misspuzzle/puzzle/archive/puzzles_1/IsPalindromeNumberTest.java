package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsPalindromeNumberTest {
	@Test
	public void testcase() {
		final IsPalindromeNumber isPalindromeNumber = new IsPalindromeNumber();

		assertTrue(isPalindromeNumber.isPalindrome(101));
		assertFalse(isPalindromeNumber.isPalindrome(1010));
	}
}
