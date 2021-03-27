package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q524_Test {
    @Test
    public void testcase() {
        List<String> list = Arrays.asList("ale", "apple", "monkey", "plea");

        String result = new Q524_FindLongestWord().findLongestWord("abpcplea", list);

        assertEquals("apple", result);
    }
}
