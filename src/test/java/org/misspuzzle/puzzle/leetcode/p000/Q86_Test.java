package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertEquals;

public class Q86_Test {
    @Test
    public void testcase() {
        final ListNode head = new ListNode(new int[]{2, 1, 5, 6, 2, 3});

        final ListNode result = new Q86_Partition().partition(head, 2);

        assertEquals(2, result.next.val);
    }


}
