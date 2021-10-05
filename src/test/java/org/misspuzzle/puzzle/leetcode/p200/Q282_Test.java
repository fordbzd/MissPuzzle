package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q282_Test {
    @Test
    public void testcase() {
        final String num = "105";

        final List<String> result = new Q282_AddOperators().addOperators(num, 5);

        assertEquals(2, result.size());
    }
}
