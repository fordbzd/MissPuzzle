package org.misspuzzle.puzzle.leetcode.p300;

public class Q331_IsValidSerialization {
    public boolean isValidSerialization(String preorder) {
        String[] values = preorder.split(",");

        if ((values.length & 1) == 0) {
            return false;
        }

        int result = dfs(values, 0);

        return result == values.length;
    }

    private int dfs(String[] values, int i) {
        if (i > values.length - 1) {
            return -1;
        }

        if (values[i].equals("#")) {
            return i + 1;
        }

        int left = dfs(values, i + 1);
        if (left == -1) {
            return -1;
        }

        int right = dfs(values, left);

        if (right == -1) {
            return -1;
        }

        return right;
    }
}
