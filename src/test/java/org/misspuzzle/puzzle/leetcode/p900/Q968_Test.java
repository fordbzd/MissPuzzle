package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q968_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = root.left = new TreeNode(2);

        TreeNode node2 = root.right = new TreeNode(3);
        TreeNode node3 = node2.left = new TreeNode(4);
        TreeNode node4 = node2.right = new TreeNode(5);

        final int result = new Q968_MinCameraCover().minCameraCover(root);

        assertEquals(2, result);
    }
}
