package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q51_Test {
    @Test
    public void testcase() {
        final List<List<String>> result = new Q51_SolveNQueens().solveNQueens(4);

        assertEquals(".Q..", result.get(0).get(0));
    }



}
