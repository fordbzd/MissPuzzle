package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q538_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        new Q538_ConvertBST().convertBST(root);

        assertEquals(13, root.val);
        assertEquals(15, root.left.val);
        assertEquals(8, root.right.val);
    }
}
