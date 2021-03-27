package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.ListNode;

public class Q160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);

        ListNode longerHead = lengthA > lengthB ? headA : headB;
        ListNode shorterHead = lengthA > lengthB ? headB : headA;

        for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
            longerHead = longerHead.next;
        }

        while (longerHead != null) {
            if (longerHead == shorterHead) {
                return longerHead;
            }

            longerHead = longerHead.next;
            shorterHead = shorterHead.next;
        }

        return null;
    }

    private int getListLength(ListNode head) {
        int length = 0;

        while (head != null) {
            head = head.next;
            length++;
        }

        return length;
    }
}
