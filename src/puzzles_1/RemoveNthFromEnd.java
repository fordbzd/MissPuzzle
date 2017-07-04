package puzzles_1;

import datastructure.ListNode;
import interfaces.Puzzle;

public class RemoveNthFromEnd implements Puzzle {

	@Override
	public void execute() {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		
		System.out.println(removeNthFromEnd(root, 2).toString());

	}
	
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
