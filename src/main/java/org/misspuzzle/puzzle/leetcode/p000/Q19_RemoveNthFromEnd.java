package org.misspuzzle.puzzle.leetcode.p000;

import org.misspuzzle.datastructure.ListNode;

public class Q19_RemoveNthFromEnd {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int step = 0;
        ListNode preRemove = null;
        ListNode current = head;
        
        while(current != null) {
            if (step < n) {
                step++;
            } else {
                if (preRemove == null) {
                    preRemove = head;
                } else {
                    preRemove = preRemove.next;
                }
            }
            
            current = current.next;
        }
        
        if (preRemove == null) {
            head = head.next;
        } else {
            preRemove.next = preRemove.next.next;
        }
        
        return head;
    }

}
