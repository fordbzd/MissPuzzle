package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q199_Test {
    @Test
    public void testcase() {

        TreeNode root = new TreeNode(1);

        TreeNode node1 = root.left = new TreeNode(2);
        TreeNode node2 = root.right = new TreeNode(3);

        TreeNode node3 = node1.right = new TreeNode(5);
        TreeNode node4 = node2.right = new TreeNode(4);

        final List<?> result = new Q199_RightSideView().rightSideView(root);

        assertEquals(1, result.get(0));
        assertEquals(3, result.get(1));
        assertEquals(4, result.get(2));

    }


}
