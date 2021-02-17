package org.misspuzzle.puzzle.leetcode.p1400;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1337_KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {

        int[] nums = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            nums[i] = binarySearch(mat[i], 0, mat[i].length);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(mat.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return (nums[n1] == nums[n2]) ? (n1 - n2) : (nums[n1] - nums[n2]);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(i);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    private int binarySearch(int[] m, int start, int end) {
        if (start >= end - 1) {
            if (m[start] == 0) {
                return -1;
            }
            return start;
        }

        // end is exclusive.
        int mid = (start + end) / 2;

        if (m[mid] == 0) {
            return binarySearch(m, start, mid);
        } else {
            return binarySearch(m, mid, end);
        }
    }
}
