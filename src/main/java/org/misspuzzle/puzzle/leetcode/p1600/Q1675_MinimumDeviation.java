package org.misspuzzle.puzzle.leetcode.p1600;

import java.util.TreeSet;

public class Q1675_MinimumDeviation {
    public int minimumDeviation(int[] nums) {

        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        for (int v : nums) {
            if ((v & 1) == 0) {
                treeSet.add(v);
            } else {
                treeSet.add(v << 1);
            }
        }

        int diff = Integer.MAX_VALUE;

        while (true) {
            Integer first = treeSet.first();
            Integer last = treeSet.last();

            diff = Math.min((last - first), diff);

            if ((last & 1) == 1) {
                return diff;
            } else {
                treeSet.remove(last);
                treeSet.add(last >> 1);
            }
        }
    }

}
