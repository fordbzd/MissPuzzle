package org.misspuzzle.puzzle.leetcode.p200;

import org.misspuzzle.datastructure.ListNode;

public class Q234_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        int count = 0;

        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            count++;
        }

        node2 = node1.next;
        node1.next = null;
        while (node2 != null) {
            ListNode temp = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = temp;
        }

        for (int i = 0; i < count; i++) {
            if (head.val != node1.val) {
                return false;
            }
            head = head.next;
            node1 = node1.next;
        }

        return true;

    }
}
