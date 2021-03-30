package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;
import org.misspuzzle.datastructure.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q971_Test {
    @Test
    public void testcase() {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = root.left = new TreeNode(2);

        TreeNode node2 = root.right = new TreeNode(3);
        TreeNode node3 = node2.left = new TreeNode(4);
        TreeNode node4 = node2.right = new TreeNode(5);

        int[] voyage = {1, 3, 4, 5, 2};

        final List<Integer> result = new Q971_FlipMatchVoyage().flipMatchVoyage(root, voyage);

        assertEquals(1, result.get(0).intValue());
    }
}
