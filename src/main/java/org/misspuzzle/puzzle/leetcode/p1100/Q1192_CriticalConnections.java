package org.misspuzzle.puzzle.leetcode.p1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1192_CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer, List<Integer>> edges = new HashMap<>();

        for (List<Integer> edge : connections) {
            if (!edges.containsKey(edge.get(0))) {
                edges.put(edge.get(0), new ArrayList<>());
            }
            if (!edges.containsKey(edge.get(1))) {
                edges.put(edge.get(1), new ArrayList<>());
            }

            edges.get(edge.get(0)).add(edge.get(1));
            edges.get(edge.get(1)).add(edge.get(0));
        }

        List<List<Integer>> result = new ArrayList<>();

        dfs(0, 2, edges, new int[n], result);

        return result;
    }

    private int dfs(int from, int rank, Map<Integer, List<Integer>> edges, int[] ranks, List<List<Integer>> result) {
        if (ranks[from] > 0) {
            return ranks[from];
        }

        ranks[from] = rank;

        int min = rank;
        for (int to : edges.get(from)) {
            if (ranks[to] != rank - 1) {
                int toRank = dfs(to, rank + 1, edges, ranks, result);

                if (toRank > rank) {
                    List<Integer> path = new ArrayList<>(2);
                    path.add(from);
                    path.add(to);

                    result.add(path);
                }

                min = Math.min(min, toRank);
            }
        }

        ranks[from] = min;

        return min;
    }
}
