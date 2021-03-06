package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q513_Test {
	@Test
	public void testcase() {
		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.right.right = new TreeNode(6);

		int result = new Q513_FindBottomLeftValue().findBottomLeftValue(root);

		assertEquals(6, result);
	}
}
