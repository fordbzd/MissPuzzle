package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q120_Test {
    @Test
    public void testcase() {
        final List<List<Integer>> list = new ArrayList<>();

        final List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list.add(list1);

        final List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list.add(list2);

        final int result = new Q120_MinimumTotal().minimumTotal(list);

        assertEquals(5, result);
    }
}
