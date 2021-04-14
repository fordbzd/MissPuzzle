package org.misspuzzle.puzzle.leetcode.p300;

import org.junit.Test;
import org.misspuzzle.datastructure.NestedInteger;
import org.misspuzzle.datastructure.NestedIntegerImpl;
import org.misspuzzle.datastructure.NestedIterator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Q341_Test {
    @Test
    public void testcase() {
        List<NestedInteger> list = new ArrayList<>();
        list.add(new NestedIntegerImpl(3));

        List<NestedInteger> list2 = new ArrayList<>();
        list2.add(new NestedIntegerImpl(4));
        list2.add(new NestedIntegerImpl(5));

        list.add(new NestedIntegerImpl(list2));

        NestedIterator nestedIterator = new Q341_NestedIterator(list).nestedIterator;

        assertEquals(3, nestedIterator.next().intValue());
        assertEquals(4, nestedIterator.next().intValue());
        assertTrue(nestedIterator.hasNext());
        assertEquals(5, nestedIterator.next().intValue());
        assertFalse(nestedIterator.hasNext());
    }
}
