package org.misspuzzle.puzzle.leetcode.p700;

import org.misspuzzle.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q623_AddOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {
            root = new TreeNode(v, root, null);

            return root;
        }

        int depth = 2;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0) {
            if (depth == d) {
                while (queue.size() > 0) {
                    TreeNode node = queue.poll();

                    node.left = new TreeNode(v, node.left, null);
                    node.right = new TreeNode(v, null, node.right);
                }

                return root;
            }

            Queue<TreeNode> queue2 = new LinkedList<>();

            while (queue.size() > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue2.add(node.left);
                }

                if (node.right != null) {
                    queue2.add(node.right);
                }
            }

            queue = queue2;
            depth++;
        }

        return root;
    }
}
