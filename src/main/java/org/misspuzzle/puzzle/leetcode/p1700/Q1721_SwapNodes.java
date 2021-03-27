package org.misspuzzle.puzzle.leetcode.p1700;

import org.misspuzzle.datastructure.ListNode;

public class Q1721_SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {

        if (head.next == null) {
            return head;
        }

        int step = 2;
        ListNode nodePreK = null;
        ListNode nodePreK2 = null;
        ListNode node = head;

        while (node != null) {
            if (step == k) {
                nodePreK = node;
            }

            if (step == k + 2) {
                nodePreK2 = head;
            }

            if (step > k + 2) {
                nodePreK2 = nodePreK2.next;
            }

            node = node.next;
            step++;
        }

        if (nodePreK == nodePreK2) {
            return head;
        }

        if (k == 1) {
            if (nodePreK2 == head) {
                ListNode tail = nodePreK2.next;
                tail.next = head;
                head.next = null;

                return tail;
            }

            ListNode tail = nodePreK2.next;
            tail.next = head.next;
            nodePreK2.next = head;
            head.next = null;

            return tail;
        }

        if (nodePreK2 == null) {
            if (nodePreK == head) {
                ListNode tail = nodePreK.next;
                tail.next = nodePreK;
                nodePreK.next = null;

                return tail;
            }

            ListNode tail = nodePreK.next;
            tail.next = head.next;
            nodePreK.next = head;
            head.next = null;

            return tail;
        }

        if (nodePreK.next == nodePreK2) {
            nodePreK.next = nodePreK2.next;
            nodePreK2.next = nodePreK2.next.next;
            nodePreK.next.next = nodePreK2;

            return head;
        }

        if (nodePreK2.next == nodePreK) {
            nodePreK2.next = nodePreK.next;
            nodePreK.next = nodePreK.next.next;
            nodePreK2.next.next = nodePreK;

            return head;
        }

        ListNode nodeK = nodePreK.next;
        nodePreK.next = nodeK.next;
        nodeK.next = nodePreK2.next.next;
        nodePreK2.next.next = nodePreK.next;
        nodePreK.next = nodePreK2.next;
        nodePreK2.next = nodeK;

        return head;
    }

}
