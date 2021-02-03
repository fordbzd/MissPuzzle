package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.ListNode;

public class Q24_SwapPairs {
	
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return head;
        }
        
        ListNode pre = null;
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (pre == null) {
                head = current.next;
                pre = current;
                current.next = head.next;
                head.next = current;
                current = current.next;
            } else {
                pre.next = current.next;
                current.next = pre.next.next;
                pre.next.next = current;
                pre = current;
                current = current.next;
            }
        }
        
        return head;
    }

}
