package org.misspuzzle.puzzle.archive;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {
	@Test
	public void testcase() {
		final int[] s = {-1, 0, 1, 2, -1, -4};

		final List<List<Integer>> result = new ThreeSum().threeSum(s);

		assertEquals(-1, result.get(0).get(0).intValue());
	}
}
