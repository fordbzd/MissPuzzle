package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q669_Test {
    @Test
    public void testcase1() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = root.left = new TreeNode(3);
        TreeNode node2 = root.right = new TreeNode(7);

        TreeNode node3 = node1.left = new TreeNode(2);
        TreeNode node4 = node1.right = new TreeNode(4);

        TreeNode node5 = node3.left = new TreeNode(1);

        TreeNode node6 = node2.left = new TreeNode(6);
        TreeNode node7 = node2.right = new TreeNode(8);

        final TreeNode result = new Q669_TrimBST().trimBST(root, 2, 3);

        assertEquals(3, result.val);
    }

    @Test
    public void testcase2() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = root.left = new TreeNode(3);
        TreeNode node2 = root.right = new TreeNode(7);

        TreeNode node3 = node1.left = new TreeNode(2);
        TreeNode node4 = node1.right = new TreeNode(4);

        TreeNode node5 = node3.left = new TreeNode(1);

        TreeNode node6 = node2.left = new TreeNode(6);
        TreeNode node7 = node2.right = new TreeNode(8);

        final TreeNode result = new Q669_TrimBST().trimBST(root, 3, 6);

        assertEquals(6, result.right.val);
    }
}
