package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q7_Test {
	@Test
	public void testcase() {
		final int result = new Q7_Reverse().reverse(-2147483648);

		assertEquals(0, result);
	}
}
