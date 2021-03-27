package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertEquals;

public class Q160_Test {
    @Test
    public void testcase1() {
        ListNode headA = new ListNode(new int[] {1 ,2});
        ListNode headB = new ListNode(new int[] {3});

        ListNode commonNode = new ListNode(4);

        headA.next.next = commonNode;
        headB.next = commonNode;

        ListNode result = new Q160_GetIntersectionNode().getIntersectionNode(headA, headB);

        assertEquals(commonNode, result);
    }


}
