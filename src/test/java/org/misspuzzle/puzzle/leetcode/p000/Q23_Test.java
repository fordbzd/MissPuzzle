package org.misspuzzle.puzzle.leetcode.p000;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertEquals;

public class Q23_Test {
	@Test
	public void testcase() {
		ListNode root1 = new ListNode(3);
		root1.next = new ListNode(7);
		root1.next.next = new ListNode(9);

		ListNode root2 = new ListNode(1);
		root2.next = new ListNode(2);
		root2.next.next = new ListNode(4);
		root2.next.next.next = new ListNode(11);

		ListNode root3 = new ListNode(5);
		root3.next = new ListNode(8);
		root3.next.next = new ListNode(10);

		ListNode[] lists = {root1, root2, root3};

		ListNode result = new Q23_MergeKLists().mergeKLists(lists);

		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
	}
}
