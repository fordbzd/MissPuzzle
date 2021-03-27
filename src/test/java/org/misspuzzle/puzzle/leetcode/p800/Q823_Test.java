package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q823_Test {
    @Test
    public void testcase() {
        int[] arr = {2, 4, 5, 10};

        int result = new Q823_NumFactoredBinaryTrees().numFactoredBinaryTrees(arr);

        assertEquals(7, result);
    }


}
