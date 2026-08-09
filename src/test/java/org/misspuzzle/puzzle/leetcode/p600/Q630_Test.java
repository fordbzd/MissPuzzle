package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q630_Test {
    @Test
    public void testcase() {

        int[][] courses = {
                {200, 1300},
                {1000, 1250},
                {2000, 3200},
                {100, 200}
        };

        int result = new Q630_ScheduleCourse().scheduleCourse(courses);

        assertEquals(3, result);
    }
}
