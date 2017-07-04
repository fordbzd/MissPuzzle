package puzzles_1;

import interfaces.Puzzle;
import datastructure.ListNode;

public class MergeTwoLists implements Puzzle {

	@Override
	public void execute() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		
		ListNode result = mergeTwoLists(l1, l2);
		
		while (result != null) {
			System.out.println(result.val);
			
			result = result.next;
		}

	}
	
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
