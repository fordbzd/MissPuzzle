package org.misspuzzle.puzzle.leetcode.dailychallange.y2021m1;

import org.misspuzzle.datastructure.FenwickTree;

public class Q1649_CreateSortedArray {

    public int createSortedArray(int[] instructions) {

        FenwickTree tree = new FenwickTree(100001);
        long sum = 0;
        long MOD = 1000000007;

        for (int i = 0; i < instructions.length; i++) {
            int value = instructions[i];
            sum += Math.min(tree.prefixSum(value - 1), i - tree.prefixSum(value));

            tree.add(value, 1);
        }

        return (int) (sum % MOD);
    }
}
