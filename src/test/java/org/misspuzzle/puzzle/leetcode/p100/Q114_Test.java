package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q114_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        new Q114_Flatten().flatten(root);

        assertEquals(3, root.right.right.val);
    }



}
