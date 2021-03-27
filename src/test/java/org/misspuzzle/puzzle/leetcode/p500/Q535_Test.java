package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q535_Test {
    @Test
    public void testcase() {
        Q535_TinyUrl tinyUrl = new Q535_TinyUrl();

        String result = tinyUrl.encode("abc");

        assertEquals("http://tinyurl.com/1", result);
        assertEquals("abc", tinyUrl.decode(result));
    }
}
