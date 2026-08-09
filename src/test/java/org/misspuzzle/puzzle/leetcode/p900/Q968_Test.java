package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.jupiter.api.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q968_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        final int result = new Q968_MinCameraCover().minCameraCover(root);

        assertEquals(2, result);
    }
}
