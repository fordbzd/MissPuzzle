package org.misspuzzle.puzzle.leetcode.p800;

import java.util.Arrays;

public class Q719_SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int right = nums[nums.length - 1] - nums[0];
        int left = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            left = Math.min(left, nums[i] - nums[i - 1]);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int count = getDistanceCount(mid, nums);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int getDistanceCount(int distance, int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int left = i;
            int right = nums.length - 1;

            while (left < right) {
                int mid = (left + right) / 2;

                if (nums[mid] - nums[i] > distance) {
                    right = mid - 1;
                } else if (left == mid) {
                    if (nums[right] - nums[i] > distance) {
                        right = left;
                    } else {
                        left = right;
                    }
                } else {
                    left = mid;
                }
            }

            count += left - i;
        }

        return count;
    }
}
