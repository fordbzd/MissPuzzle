package org.misspuzzle.puzzle.leetcode.p1700;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertEquals;

public class Q1721_Test {
    @Test
    public void testcase1() {
        ListNode head = new ListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 3, 5});

        ListNode result = new Q1721_SwapNodes().swapNodes(head, 2);

        assertEquals(3, result.next.val);
    }

    @Test
    public void testcase2() {
        ListNode head = new ListNode(new int[]{1, 2, 3});

        ListNode result = new Q1721_SwapNodes().swapNodes(head, 2);

        assertEquals(2, result.next.val);
    }

    @Test
    public void testcase3() {
        ListNode head = new ListNode(new int[]{55,60,78,53,93,37,31,4,61,11,13,51,34,83,24,96,5,77,1,67});

        ListNode result = new Q1721_SwapNodes().swapNodes(head, 11);

        assertEquals(55, result.val);
    }

    @Test
    public void testcase4() {
        ListNode head = new ListNode(new int[]{1, 2});

        ListNode result = new Q1721_SwapNodes().swapNodes(head, 2);

        assertEquals(2, result.val);
    }
}
