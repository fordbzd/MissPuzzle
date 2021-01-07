package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesTest {
	@Test
	public void testcase() {
		int[] nums = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4};

		final int result = new RemoveDuplicates().removeDuplicates(nums);

		assertEquals(4, result);
	}
}
