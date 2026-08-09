package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q71_Test {
    @Test
    public void testcase() {
        final String path = "/a/./b/../../c/";

        final String result = new Q71_SimplifyPath().simplifyPath(path);

        assertEquals("/c", result);
    }
}
