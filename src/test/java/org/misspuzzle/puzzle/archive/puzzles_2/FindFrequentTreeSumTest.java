package org.misspuzzle.puzzle.archive.puzzles_2;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class FindFrequentTreeSumTest {
	@Test
	public void testcase() {
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(2);
		root.right = new TreeNode(-3);

		int[] result = new FindFrequentTreeSum().findFrequentTreeSum(root);

		assertEquals(2, result[0]);
		assertEquals(4, result[1]);
		assertEquals(-3, result[2]);
	}
}
