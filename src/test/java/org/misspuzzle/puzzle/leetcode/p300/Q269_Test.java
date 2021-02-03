package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q269_Test {
	@Test
	public void testcase() {
		final String result = new Q269_AlienOrder().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});

		assertEquals("wertf", result);
	}
}
