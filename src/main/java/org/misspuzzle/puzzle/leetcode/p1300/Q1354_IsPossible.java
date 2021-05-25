package org.misspuzzle.puzzle.leetcode.p1300;

import java.util.PriorityQueue;

public class Q1354_IsPossible {
    public boolean isPossible(int[] target) {
        if (target.length == 1 && target[0] != 1) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        long sum = 0;
        for (int t : target) {
            sum += t;
            pq.offer(t);
        }

        while (pq.peek() != 1) {
            long t = pq.poll();
            long gap = sum - t;
            long before = gap == 1 ? 1 : t % gap;

            if ((t << 1) < sum || before < 1) {
                return false;
            }

            sum = sum - t + before;

            pq.offer((int) before);
        }

        return true;
    }
}
