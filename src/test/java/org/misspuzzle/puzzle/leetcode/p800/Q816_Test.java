package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q816_Test {
    @Test
    public void testcase() {
        List<String> result = new Q816_AmbiguousCoordinates().ambiguousCoordinates("(123)");

        assertEquals(4, result.size());
    }
}
