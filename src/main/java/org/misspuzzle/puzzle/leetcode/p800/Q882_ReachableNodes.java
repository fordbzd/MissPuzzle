package org.misspuzzle.puzzle.leetcode.p800;

import java.util.*;

public class Q882_ReachableNodes {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], edge[2]);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        queue.offer(new int[]{0, maxMoves});

        Set<Integer> visited = new HashSet<>();

        int sum = 0;

        while (queue.size() > 0) {
            int[] top = queue.poll();
            int node = top[0];
            int move = top[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            sum++;

            Map<Integer, Integer> neighbors = graph.get(node);
            if (neighbors == null) {
                continue;
            }

            for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                int neighbor = entry.getKey();
                int dist = entry.getValue();

                if (!visited.contains(neighbor) && move > dist) {
                    queue.offer(new int[]{neighbor, move - dist - 1});
                }

                graph.get(neighbor).put(node, graph.get(neighbor).get(node) - Math.min(move, dist));
                sum += Math.min(move, dist);
            }
        }

        return sum;
    }
}
