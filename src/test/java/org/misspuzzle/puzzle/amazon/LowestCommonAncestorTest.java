package org.misspuzzle.puzzle.amazon;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorTest {

	@Test
	public void testcase() {
		//    6
		//  /   \
		//  2    8
		// / \  / \
		// 0 4  7 9
		//  / \    \
		//  3 5    1

		TreeNode root = new TreeNode(6);

		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		root.right.right.right = new TreeNode(1);

		// Test
		TreeNode result = new LowestCommonAncestor().lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5));
		assertEquals(2, result.val);
	}
}
