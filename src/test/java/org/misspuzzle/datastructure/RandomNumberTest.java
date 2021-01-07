package org.misspuzzle.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RandomNumberTest {
	@Test
	public void testcase() {
		final int result = new RandomNumber().generate(0, 100);

		assertTrue(result >= 0 && result < 100);
	}
}
