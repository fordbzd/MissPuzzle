package org.misspuzzle.puzzle.leetcode.p1300;

import org.misspuzzle.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1302_DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = 0;

        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            sum = 0;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }

            queue = queue2;
        }

        return sum;
    }
}
