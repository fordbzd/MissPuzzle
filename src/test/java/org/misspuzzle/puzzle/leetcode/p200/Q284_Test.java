package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q284_Test {
    @Test
    public void testcase() {

        List<Integer> list = Arrays.stream(new int[]{1, 2, 3, 4, 5}).boxed().collect(Collectors.toList());

        final Q284_PeekingIterator iterator = new Q284_PeekingIterator(list.iterator());

        assertEquals(1, iterator.peek().intValue());
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.peek().intValue());
        assertEquals(2, iterator.peek().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(3, iterator.next().intValue());
        assertTrue(iterator.hasNext());
    }


}
