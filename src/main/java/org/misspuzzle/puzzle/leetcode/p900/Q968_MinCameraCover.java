package org.misspuzzle.puzzle.leetcode.p900;

import org.misspuzzle.datastructure.TreeNode;

public class Q968_MinCameraCover {
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Result result = dfs(root);

        return Math.min(result.withCamera, result.withChildren);
    }

    private Result dfs(TreeNode root) {

        if (root == null) {
            return new Result(2000, 0, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        int withCamera = Math.min(Math.min(left.withCamera, left.withChildren), left.withParent)
                + Math.min(Math.min(right.withCamera, right.withChildren), right.withParent)
                + 1;

        int withChildren = Math.min(
            Math.min(left.withCamera, left.withChildren) + right.withCamera,
            Math.min(right.withCamera, right.withChildren) + left.withCamera
        );

        int withParent = Math.min(left.withCamera, left.withChildren)
                + Math.min(right.withCamera, right.withChildren);

        return new Result(withCamera, withChildren, withParent);
    }

    static class Result {
        int withCamera;
        int withChildren;
        int withParent;

        Result(int withCamera, int withChildren, int withParent) {
            this.withCamera = withCamera;
            this.withChildren = withChildren;
            this.withParent = withParent;
        }
    }
}
