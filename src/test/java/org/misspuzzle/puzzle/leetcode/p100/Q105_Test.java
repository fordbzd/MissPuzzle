package org.misspuzzle.puzzle.leetcode.p100;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q105_Test {
    @Test
    public void testcase() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = new Q105_BuildTree().buildTree(preorder, inorder);

        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }
}
