package org.misspuzzle.puzzle.leetcode.dailychallange.y2021m2;

import org.misspuzzle.datastructure.TreeNode;

public class Q669_TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high ) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

}
