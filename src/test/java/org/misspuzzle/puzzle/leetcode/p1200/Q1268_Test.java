package org.misspuzzle.puzzle.leetcode.p1200;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q1268_Test {
    @Test
    public void testcase() {

        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};

        List<List<String>> result = new Q1268_SuggestedProducts().suggestedProducts(products, "mouse");

        assertEquals(3, result.get(0).size());
    }
}
