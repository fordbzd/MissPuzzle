package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertNull;

public class Q19_Test {
    @Test
    public void testcase() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        final ListNode result = new Q19_RemoveNthFromEnd().removeNthFromEnd(root, 2);

        assertNull(result.next.next);
    }
}
