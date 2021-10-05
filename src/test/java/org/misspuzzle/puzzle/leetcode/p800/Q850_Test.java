package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q850_Test {
    @Test
    public void testcase() {
        int[][] rectangles = {
                {0, 0, 2, 2},
                {1, 0, 2, 3},
                {1, 0, 3, 1}
        };

        int result = new Q850_RectangleArea().rectangleArea(rectangles);

        assertEquals(6, result);

    }
}
