package org.misspuzzle.puzzle.leetcode.p500;

import org.misspuzzle.datastructure.TreeNode;

public class Q538_ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);

        return root;
    }

    private int dfs(TreeNode node, int greaterSum) {
        if (node == null) {
            return 0;
        }

        int rightSum = dfs(node.right, greaterSum);
        node.val += rightSum + greaterSum;

        int leftSum = dfs(node.left, node.val);

        return node.val + leftSum - greaterSum;
    }
}
