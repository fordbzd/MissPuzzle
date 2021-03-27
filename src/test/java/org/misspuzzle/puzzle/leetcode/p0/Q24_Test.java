package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertEquals;

public class Q24_Test {
    @Test
    public void testcase() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ListNode result = new Q24_SwapPairs().swapPairs(root);

        assertEquals("2 -> 1 -> 4 -> 3", result.toString());
    }
}
