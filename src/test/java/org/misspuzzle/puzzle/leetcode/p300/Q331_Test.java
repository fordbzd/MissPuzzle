package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Q331_Test {
    @Test
    public void testcase() {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        boolean result = new Q331_IsValidSerialization().isValidSerialization(preorder);

        assertTrue(result);
    }
}
