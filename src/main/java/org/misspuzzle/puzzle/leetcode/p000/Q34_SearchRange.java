package org.misspuzzle.puzzle.leetcode.p000;

public class Q34_SearchRange {
    public int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length;

        // Find left.
        while (end > start) {
            int mid = (start + end) / 2;

            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                if (end - start == 1) {
                    break;
                }

                if (end == mid + 1) {
                    start = nums[start] == target ? start : mid;
                    break;
                }

                end = mid + 1;
            }
        }

        if (start >= nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        int left = start;

        end = nums.length;

        // Find right.
        while (end > start) {
            int mid = (start + end) / 2;

            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                if (end - start == 1) {
                    break;
                }

                start = mid;
            }
        }

        return new int[]{left, start};
    }
}
