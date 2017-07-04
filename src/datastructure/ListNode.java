package datastructure;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
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