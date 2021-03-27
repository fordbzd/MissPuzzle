package org.misspuzzle.puzzle.leetcode.p1000;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q916_Test {
    @Test
    public void testcase() {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"e", "o"};

        List<String> result = new Q916_WordSubsets().wordSubsets(A, B);

        assertEquals(3, result.size());
    }
}
