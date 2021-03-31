package org.misspuzzle.puzzle.leetcode.p000;

import org.misspuzzle.datastructure.ListNode;

public class Q23_MergeKLists {
	
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists.length == 0) {
    		return null;
    	} else if (lists.length == 1) {
    		return lists[0];
    	}
        
        return partition(lists, 0, lists.length - 1);
    }
    
    private ListNode partition(ListNode[] lists, int start, int end) {
    	if (start == end) {
    		return lists[start];
    	} else if (end > start) {
    		return mergeTwoLists(partition(lists, start, (start + end) / 2), partition(lists, (start + end) / 2 + 1, end));
    	} else {
    		return null;
    	}
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null) {
    		return null;
    	} else if (l1 == null) {
    		return l2;
    	} else if (l2 == null) {
    		return l1;
    	}
    	
    	ListNode root = null;
    	ListNode current = null;
    	
    	if (l1.val < l2.val) {
    		root = current = l1;
    		l1 = l1.next;
    	} else {
    		root = current = l2;
    		l2 = l2.next;
    	}
    	
    	while (l1 != null || l2 != null) {
    		if (l1 == null) {
    			current.next = l2;
    			break;
    		} else if (l2 == null) {
    			current.next = l1;
    			break;
    		} else if (l1.val < l2.val) {
    			current.next = l1;
    			current = l1;
    			l1 = l1.next;
    		} else {
    			current.next = l2;
    			current = l2;
    			l2 = l2.next;
    		}
    	}
    	
    	return root;
    }

}
