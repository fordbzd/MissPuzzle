package org.misspuzzle.puzzle.leetcode.p000;

import org.misspuzzle.datastructure.ListNode;

public class Q21_MergeTwoLists {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode node = null;
        
        while(l1 != null || l2 != null) {
        	if (l1 == null) {
        		if (node != null) {
        			node.next = l2;
        		}
        		
        		node = l2;
        		l2 = l2.next;
        	} else if (l2 == null) {
        		if (node != null) {
        			node.next = l1;
        		}
        		
        		node = l1;
        		l1 = l1.next;
        	} else {
        		if (l1.val < l2.val) {
            		if (node != null) {
            			node.next = l1;
            		}
            		
            		node = l1;
            		l1 = l1.next;
        		} else {
            		if (node != null) {
            			node.next = l2;
            		}
            		
            		node = l2;
            		l2 = l2.next;
        		}
        	}
        	
        	if (root == null) {
        		root = node;
        	}
        }
        
        return root;
    }

}
