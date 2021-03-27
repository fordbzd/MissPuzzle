package org.misspuzzle.puzzle.leetcode.p100;

public class Q191_HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;

        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }

        return sum;
    }
}
