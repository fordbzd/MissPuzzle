package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q124_Test {
    @Test
    public void testcase1() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = new Q124_MaxPathSum().maxPathSum(root);

        assertEquals(42, result);
    }

    @Test
    public void testcase2() {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(1);

        int result = new Q124_MaxPathSum().maxPathSum(root);

        assertEquals(1, result);
    }

}
