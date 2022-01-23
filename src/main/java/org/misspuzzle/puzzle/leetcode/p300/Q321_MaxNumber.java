package org.misspuzzle.puzzle.leetcode.p300;

public class Q321_MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int[][] max1 = getMaxNumber(nums1);
        int[][] max2 = getMaxNumber(nums2);

        int min = Math.max(0, k - nums2.length);
        int max = Math.min(nums1.length, k);

        int[] result = new int[k];
        for (int i = min; i <= max; i++) {
            int[] merged = merge(max1[i], max2[k - i], i, k - i);
            if (isBigger(merged, result, 0, 0, k, k)) {
                result = merged;
            }
        }

        return result;
    }

    private boolean isBigger(int[] max1, int[] max2, int i, int j, int n1, int n2) {
        while (i < max1.length && j < max2.length) {
            if (max1[i] != max2[j]) {
                return max1[i] > max2[j];
            }

            i++;
            j++;
        }

        return (n1 - i) > (n2 - j);
    }

    private int[] merge(int[] max1, int[] max2, int n1, int n2) {
        int i = 0;
        int j = 0;
        int pos = 0;

        int[] merged = new int[n1 + n2];
        while (pos < n1 + n2) {
            if (i >= n1) {
                merged[pos++] = max2[j++];
            } else if (j >= n2) {
                merged[pos++] = max1[i++];
            } else if (isBigger(max1, max2, i, j, n1, n2)) {
                merged[pos++] = max1[i++];
            } else {
                merged[pos++] = max2[j++];
            }
        }

        return merged;
    }

    private int[][] getMaxNumber(int[] nums) {
        int n = nums.length;

        int[][] result = new int[n + 1][n];
        result[n] = nums;

        int pos = 0;

        for (int i = n - 1; i > 0; i--) {
            while (pos < i && result[i + 1][pos] >= result[i + 1][pos + 1]) {
                pos++;
            }

            for (int j = 0; j < i; j++) {
                result[i][j] = j < pos ? result[i + 1][j] : result[i + 1][j + 1];
            }

            if (pos != 0) {
                pos--;
            }
        }

        return result;
    }
}
