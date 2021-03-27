package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q637_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = root.left = new TreeNode(3);
        TreeNode node2 = root.right = new TreeNode(7);

        TreeNode node3 = node1.left = new TreeNode(2);
        TreeNode node4 = node1.right = new TreeNode(4);

        TreeNode node5 = node3.left = new TreeNode(1);

        TreeNode node6 = node2.left = new TreeNode(6);
        TreeNode node7 = node2.right = new TreeNode(8);

        final List<Double> result = new Q637_AverageOfLevels().averageOfLevels(root);

        assertEquals(5.0, result.get(0), 0);
        assertEquals(5.0, result.get(1), 0);
        assertEquals(5.0, result.get(2), 0);
        assertEquals(1.0, result.get(3), 0);
    }
}
