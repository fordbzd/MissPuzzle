package org.misspuzzle.puzzle.archive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CanCrossTest {
	@Test
	public void testcase() {
		final boolean result = new CanCross().canCross(new int[]{0,1,2,3,4,8,9,11});

		assertFalse(result);
	}
}