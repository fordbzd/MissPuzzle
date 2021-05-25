package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.TreeNode;

public class Q114_Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        TreeNode right = root.right;
        TreeNode last = root;

        if (root.left != null) {
            last = dfs(root.left);
            root.right = root.left;
            last.right = right;
            root.left = null;
        }

        if (right != null) {
            last = dfs(right);
        }

        return last;
    }
}
