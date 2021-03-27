package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.TreeNode;

public class Q124_MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] result = dfs(root);

        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{-2000, -2000};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int self = Math.max(Math.max(left[0], right[0]) + node.val, node.val);

        return new int[]{
            self,
            Math.max(Math.max(Math.max(left[1], right[1]), left[0] + right[0] + node.val), self)
        };
    }
}
