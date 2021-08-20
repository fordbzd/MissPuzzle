package org.misspuzzle.puzzle.leetcode.p1300;

import java.util.*;

public class Q1383_MaxPerformance {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i) {
            engineers[i] = new int[] {efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        long res = 0;
        long speedSum = 0;

        for (int[] engineer : engineers) {
            if (minHeap.size() < k || engineer[1] > minHeap.peek()) {
                minHeap.add(engineer[1]);
                speedSum += engineer[1];

                if (minHeap.size() > k) {
                    speedSum -= minHeap.poll();
                }
                res = Math.max(res, (speedSum * engineer[0]));
            }
        }

        return (int) (res % (long)(1e9 + 7));
    }
}
