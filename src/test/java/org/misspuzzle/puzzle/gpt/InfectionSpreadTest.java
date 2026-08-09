package org.misspuzzle.puzzle.gpt;

import org.junit.Test;
import org.misspuzzle.puzzle.gpt.InfectionSpread;

import static org.junit.Assert.*;

public class InfectionSpreadTest {

    @Test
	public void testcase() {
		int[][] grid = {
            {1, 1, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        // infectionSpread.debug = true;
        int result = infectionSpread.spread(grid, 2, 2);

        assertEquals(4, result);
	}

    @Test
    public void testSingleCell() {
        int[][] grid = {
            {1}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        int result = infectionSpread.spread(grid, 3, 1);

        assertEquals(3, result);
    }

    @Test
    public void testQuickDieOutWithD1() {
        int[][] grid = {
            {1, 0},
            {0, 0}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        int result = infectionSpread.spread(grid, 1, 1);

        assertEquals(1, result);
    }

    @Test
    public void testLargeD() {
        int[][] grid = {
            {1, 0},
            {0, 0}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        int result = infectionSpread.spread(grid, 5, 1);

        assertEquals(5, result);
    }

    @Test
    public void testPermanentImmuneWalls() {
        int[][] grid = {
            {1, 0, 2, 0},
            {0, 0, 2, 0},
            {0, 0, 2, 0}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        int result = infectionSpread.spread(grid, 100, 1);

        assertEquals(101, result);
    }

    @Test
    public void testThresholdK2WithRecovery() {
        int[][] grid = {
            {1, 1, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        // infectionSpread.debug = true;
        int result = infectionSpread.spread(grid, 2, 2);

        assertEquals(4, result);
    }

    @Test
    public void testAlreadyStable() {
        int[][] grid = {
            {2, 0},
            {0, 2}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        int result = infectionSpread.spread(grid, 5, 1);

        assertEquals(0, result);
    }

    @Test
    public void testNoInfectedCells() {
        int[][] grid = {
            {0, 0},
            {0, 0}
        };

        InfectionSpread infectionSpread = new InfectionSpread();
        int result = infectionSpread.spread(grid, 3, 1);

        assertEquals(0, result);
    }
    
}
