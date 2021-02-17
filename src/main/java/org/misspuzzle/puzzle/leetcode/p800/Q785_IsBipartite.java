package org.misspuzzle.puzzle.leetcode.p800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q785_IsBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        set1.add(0);

        while (queue.size() > 0) {
            int p = queue.poll();
            Set<Integer> setSelf;
            Set<Integer> setOther;

            if (set1.contains(p)) {
                setSelf = set1;
                setOther = set2;
            } else {
                setSelf = set2;
                setOther = set1;
            }

            for (int n : graph[p]) {
                if (setSelf.contains(n)) {
                    return false;
                } else if (!setOther.contains(n)) {
                    setOther.add(n);
                    queue.add(n);
                }
            }

            if (queue.size() == 0 && (set1.size() + set2.size() < graph.length)) {
                for (int i = 0; i < graph.length; i++) {
                    if (!set1.contains(i) && !set2.contains(i)) {
                        queue.add(i);
                        set1.add(i);
                        break;
                    }
                }
            }
        }

        return true;
    }
}
