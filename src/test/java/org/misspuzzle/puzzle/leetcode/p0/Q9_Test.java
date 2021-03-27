package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q9_Test {
	@Test
	public void testcase() {
		final Q9_IsPalindrome result = new Q9_IsPalindrome();

		assertTrue(result.isPalindrome(101));
		assertFalse(result.isPalindrome(1010));
	}
}
