package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_RightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }

        while (queue.size() > 0) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            TreeNode node = null;

            while (queue.size() > 0) {
                node = queue.poll();

                if (node.left != null) {
                    nextQueue.add(node.left);
                }

                if (node.right != null) {
                    nextQueue.add(node.right);
                }
            }

            result.add(node.val);

            queue = nextQueue;
        }

        return result;
    }
}
