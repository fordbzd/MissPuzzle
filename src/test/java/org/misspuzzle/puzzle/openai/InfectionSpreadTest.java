package org.misspuzzle.puzzle.openai;

import org.junit.Test;
import org.misspuzzle.puzzle.amazon.BaseballScore;

import static org.junit.Assert.assertEquals;

public class InfectionSpreadTest {

    @Test
	public void testcase() {
		int[][] grid = {
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        int result = new InfectionSpread().spread(grid);

        assertEquals(3, result);
	}
    
}
