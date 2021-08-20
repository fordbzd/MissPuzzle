package org.misspuzzle.puzzle.leetcode.p1600;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1632_Test {
    @Test
    public void testcase1() {
        int[][] matrix = {
                {-16, -33, -6, -43},
                {-16, -21, 6, -3}
        };
        int[][] result = new Q1632_MatrixRankTransform().matrixRankTransform(matrix);

        assertEquals(4, result[0][0]);
    }

    @Test
    public void testcase2() {
        int[][] matrix = {
                {-42, 13, 40, 11, -43},
                {-4, -45, 6, -43, -49},
                {14, -43, -32, 39, -43}
        };
        int[][] result = new Q1632_MatrixRankTransform().matrixRankTransform(matrix);

        assertEquals(3, result[0][4]);
    }

    @Test
    public void testcase3() {
        int[][] matrix = {
                {26,-28,-37,43},
                {-37,-3,40,32},
                {11,49,32,32},
                {31,-39,32,12}
        };
        int[][] result = new Q1632_MatrixRankTransform().matrixRankTransform(matrix);

        assertEquals(5, result[2][2]);
    }
}
