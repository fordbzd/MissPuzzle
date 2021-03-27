package org.misspuzzle.puzzle.leetcode.p300;

public class Q330_MinPatches {
    public int minPatches(int[] nums, int n) {
        int firstMiss = 1;
        int added = 0;
        int current = 0;

        while (firstMiss < n && firstMiss >= 0) {
            if (current < nums.length && (firstMiss >= nums[current])) {
                firstMiss += nums[current];
                current++;
            } else {
                firstMiss += firstMiss;
                added++;
            }

        }

        return added;

    }
}
