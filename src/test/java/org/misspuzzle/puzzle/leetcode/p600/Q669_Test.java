package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.jupiter.api.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q669_Test {
    @Test
    public void testcase1() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        node1.left = new TreeNode(2);
        node1.right = new TreeNode(4);

        node1.left.left = new TreeNode(1);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        final TreeNode result = new Q669_TrimBST().trimBST(root, 2, 3);

        assertEquals(3, result.val);
    }

    @Test
    public void testcase2() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        node1.left = new TreeNode(2);
        node1.right = new TreeNode(4);

        node1.left.left = new TreeNode(1);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        final TreeNode result = new Q669_TrimBST().trimBST(root, 3, 6);

        assertEquals(6, result.right.val);
    }
}
