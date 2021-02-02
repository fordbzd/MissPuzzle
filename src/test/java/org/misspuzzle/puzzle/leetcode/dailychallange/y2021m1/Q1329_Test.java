package org.misspuzzle.puzzle.leetcode.dailychallange.y2021m1;

import org.junit.Test;
import org.misspuzzle.utils.Printer;

import static org.junit.Assert.assertEquals;

public class Q1329_Test {
    @Test
    public void testcase() {

        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };

        mat = new Q1329_DiagonalSort().diagonalSort(mat);

        Printer.printIntMatrix(mat);

        assertEquals(1, mat[0][0]);
    }
}
