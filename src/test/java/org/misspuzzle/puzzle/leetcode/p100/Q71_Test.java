package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q71_Test {
    @Test
    public void testcase() {
        final String path = "/a/./b/../../c/";

        final String result = new Q71_SimplifyPath().simplifyPath(path);

        assertEquals("/c", result);
    }
}
