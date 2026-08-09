package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q7_Test {
	@Test
	public void testcase() {
		final int result = new Q7_Reverse().reverse(-2147483648);

		assertEquals(0, result);
	}
}
