package org.misspuzzle.puzzle.leetcode.p600;

import java.util.HashSet;
import java.util.Set;

public class Q575_DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int t : candyType) {
            set.add(t);
        }

        return Math.min(candyType.length / 2, set.size());
    }
}
