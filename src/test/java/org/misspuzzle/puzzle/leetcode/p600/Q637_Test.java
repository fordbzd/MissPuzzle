package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.jupiter.api.Test;
import org.misspuzzle.datastructure.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q637_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        node1.left = new TreeNode(2);
        node1.right = new TreeNode(4);

        node1.left.left = new TreeNode(1);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        final List<Double> result = new Q637_AverageOfLevels().averageOfLevels(root);

        assertEquals(5.0, result.get(0), 0);
        assertEquals(5.0, result.get(1), 0);
        assertEquals(5.0, result.get(2), 0);
        assertEquals(1.0, result.get(3), 0);
    }
}
