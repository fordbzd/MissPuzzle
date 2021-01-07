package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenSumTest {

	@Test
	public void testcase() {
		int[] test = {10, 20, 30, 5 , 40, 50, 40, 15, 13};

		try {
			int[][] a = new EvenSum().splitEvenly(test);

			assertEquals(10, a[0][0]);
			assertEquals(5, a[1][0]);

		} catch (EvenSum.InvalidInputException e) {
			e.printStackTrace();
		}
	}
}
