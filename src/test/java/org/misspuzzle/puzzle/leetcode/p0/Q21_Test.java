package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertEquals;

public class Q21_Test {
	@Test
	public void testcase() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);

		ListNode result = new Q21_MergeTwoLists().mergeTwoLists(l1, l2);

		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
	}
}
