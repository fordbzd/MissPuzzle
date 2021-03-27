package org.misspuzzle.puzzle.leetcode.p1200;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1249_Test {

    @Test
    public void testcase() {

        String result = new Q1249_MinRemoveToMakeValid().minRemoveToMakeValid("lee(t(c)o)de)");

        assertEquals("lee(t(c)o)de", result);
    }

}
