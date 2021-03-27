package org.misspuzzle.puzzle.leetcode.p600;

import org.misspuzzle.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637_AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);

        while (queue1.size() > 0) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            long sum = 0;
            int count = queue1.size();

            while (queue1.size() > 0) {
                TreeNode node = queue1.poll();
                sum += node.val;

                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }

            queue1 = queue2;
            result.add(sum / (double) count);
        }

        return result;
    }
}
