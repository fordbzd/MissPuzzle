package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q269_Test {
	@Test
	public void testcase() {
		final String result = new Q269_AlienOrder().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});

		assertEquals("wertf", result);
	}
}
