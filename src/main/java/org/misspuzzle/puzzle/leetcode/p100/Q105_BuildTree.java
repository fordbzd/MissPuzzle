package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.TreeNode;

public class Q105_BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, inorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int current, int[] inorder, int left, int right) {
        TreeNode root = new TreeNode(preorder[current]);

        int mid = -1;
        for (int i = left; i <= right; i++) {
            if (inorder[i] == preorder[current]) {
                mid = i;
                break;
            }
        }

        if (mid != left) {
            root.left = dfs(preorder, current + 1, inorder, left, mid - 1);
        }

        if (mid != right) {
            root.right = dfs(preorder, current + (mid - left) + 1, inorder, mid + 1, right);
        }

        return root;
    }
}
