package org.misspuzzle.puzzle.leetcode.p1300;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class Q1302_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        final int result = new Q1302_DeepestLeavesSum().deepestLeavesSum(root);

        assertEquals(4, result);
    }
}
