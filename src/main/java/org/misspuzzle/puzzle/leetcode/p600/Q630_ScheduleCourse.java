package org.misspuzzle.puzzle.leetcode.p600;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q630_ScheduleCourse {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        int time = 0;
        for (int[] current : courses) {
            if (time + current[0] <= current[1]) {
                pq.offer(current);
                time += current[0];
            } else {
                int[] maxCourse = pq.peek();

                if (pq.size() > 0 && maxCourse[0] > current[0]
                        && time - maxCourse[0] + current[0] <= current[1]) {

                    pq.poll();
                    pq.offer(current);

                    time = time - maxCourse[0] + current[0];
                }
            }
        }

        return pq.size();
    }
}
