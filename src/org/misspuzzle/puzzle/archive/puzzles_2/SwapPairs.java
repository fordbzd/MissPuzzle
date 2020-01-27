package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

import org.misspuzzle.datastructure.ListNode;

public class SwapPairs implements Puzzle {

	@Override
	public void execute() {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		
		System.out.println(swapPairs(root).toString());

	}
	
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
