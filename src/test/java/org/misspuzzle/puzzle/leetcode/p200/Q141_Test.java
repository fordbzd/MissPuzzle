package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q141_Test {
    @Test
    public void testcase1() {
        ListNode head = new ListNode(new int[]{1, 2, 3});

        head.next.next.next = head;

        boolean result = new Q141_HasCycle().hasCycle(head);

        assertTrue(result);
    }

    @Test
    public void testcase2() {
        ListNode head = new ListNode(new int[]{1, 2, 3});

        boolean result = new Q141_HasCycle().hasCycle(head);

        assertFalse(result);
    }
}
