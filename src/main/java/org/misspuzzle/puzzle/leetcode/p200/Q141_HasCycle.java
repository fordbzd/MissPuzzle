package org.misspuzzle.puzzle.leetcode.p200;

import org.misspuzzle.datastructure.ListNode;

public class Q141_HasCycle {
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode n1 = head;
        ListNode n2 = head.next;

        while (n1 != null && n2 != null) {
            if (n1 == n2) {
                return true;
            }

            n1 = n1.next;
            if (n2.next != null) {
                n2 = n2.next.next;
            } else {
                return false;
            }
        }

        return false;

    }


}
