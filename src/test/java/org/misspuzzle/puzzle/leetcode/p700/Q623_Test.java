package org.misspuzzle.puzzle.leetcode.p700;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q623_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(4);

        TreeNode node1 = root.left = new TreeNode(2);

        TreeNode node2 = node1.left = new TreeNode(3);
        TreeNode node3 = node1.right = new TreeNode(1);

        final TreeNode result = new Q623_AddOneRow().addOneRow(root, 1, 3);

        assertEquals(1, result.left.left.val);
        assertEquals(1, result.left.right.val);
    }
}
