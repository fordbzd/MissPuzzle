package org.misspuzzle.datastructure;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public ListNode(int[] arr) {
		if (arr.length > 0) {
			this.val = arr[0];
			
			ListNode node = this;
			
			for (int i = 1; i < arr.length; i++) {
				node.next = new ListNode(arr[i]);
				node = node.next;
			}
		}
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(val);
		
		ListNode next = this.next;
		while (next != null) {
			s.append(" -> " + next.val);
			
			next = next.next;
		}
		
		return s.toString();
	}
}