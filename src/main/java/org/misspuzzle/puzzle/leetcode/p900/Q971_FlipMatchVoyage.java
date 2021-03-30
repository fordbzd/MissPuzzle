package org.misspuzzle.puzzle.leetcode.p900;

import org.misspuzzle.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q971_FlipMatchVoyage {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        List<Integer> result = new LinkedList<>();

        if (dfs(root, voyage, 0, result) == -1) {
            result.clear();
            result.add(-1);
        }

        return result;
    }

    private int dfs(TreeNode root, int[] voyage, int step, List<Integer> result) {
        if (root == null) {
            return step;
        } else if (root.val != voyage[step]) {
            return -1;
        }

        int next;

        if (root.left != null && root.left.val != voyage[step + 1]) {
            next = dfs(root.right, voyage, step + 1, result);

            if (next == -1) {
                return -1;
            } else {
                result.add(root.val);

                return dfs(root.left, voyage, next, result);
            }
        }

        next = dfs(root.left, voyage, step + 1, result);
        if (next == -1) {
            return -1;
        } else {
            return dfs(root.right, voyage, next, result);
        }
    }
}
