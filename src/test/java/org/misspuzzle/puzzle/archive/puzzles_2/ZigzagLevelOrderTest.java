package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ZigzagLevelOrderTest {
	@Test
	public void testcase() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> result = new ZigzagLevelOrder().zigzagLevelOrder(root);

		assertEquals(3, result.get(0).get(0).intValue());
	}
}
