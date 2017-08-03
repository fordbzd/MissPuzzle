package puzzles_2;

import datastructure.ListNode;
import interfaces.Puzzle;

public class ReverseKGroup implements Puzzle {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ListNode root = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7});

		System.out.println(reverseKGroup(root, 5));
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        
    	ListNode start = null;
    	ListNode end = head;
    	ListNode tempStart;
    	
    	ListNode n1;
    	ListNode n2;
    	ListNode temp;
    	
    	while(end != null) {
    		// 1. Check if enough k nodes.
    		for (int i = 0; i < k; i++) {
    			if (end == null) {
    				return head;
    			}
    			
    			end = end.next;
    		}
    		
    		// 2. Reverse k nodes.
    		tempStart = n1 = start == null ? head : start.next;
    		n2 = n1.next;
    		
    		n1.next = end;
    		
    		while (n2 != end) {
    			temp = n2.next;
    			
    			n2.next = n1;
    			
    			n1 = n2;
    			n2 = temp;
    		}
    		
    		if (start != null) {
    			start.next = n1;
    		} else {
    			head = n1;
    		}
    		
    		// 3. Reset start.
    		start = tempStart;
    	}
    	
    	return head;
    	
    }

}
