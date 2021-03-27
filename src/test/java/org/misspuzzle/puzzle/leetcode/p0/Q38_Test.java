package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q38_Test {
	@Test
	public void testcase() {
		final String result = new Q38_CountAndSay().countAndSay(6);

		assertEquals("312211", result);
	}
}
