package org.misspuzzle.puzzle.leetcode.p800;

import java.util.*;

public class Q834_SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }

            map.get(edge[0]).add(edge[1]);

            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }

            map.get(edge[1]).add(edge[0]);
        }

        int[][] sumToRoot = new int[n][];

        getRootSum(map, sumToRoot, 0, new HashSet<>());

        int[] result = new int[n];
        getAllNodesSum(map, sumToRoot, 0, result, sumToRoot[0][1] + n, new HashSet<>());

        return result;
    }

    private int[] getRootSum(Map<Integer, List<Integer>> map, int[][] sumToRoot, int node, Set<Integer> visited) {
        visited.add(node);

        int[] nodeSum = {1, 0};

        for (int child : map.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(child)) {
                int[] childSum = getRootSum(map, sumToRoot, child, visited);

                nodeSum[0] += childSum[0];
                nodeSum[1] += childSum[1] + childSum[0];
            }
        }

        sumToRoot[node] = nodeSum;
        return nodeSum;
    }

    private void getAllNodesSum(Map<Integer, List<Integer>> map, int[][] sumToRoot, int node, int[] result, int parentSum, Set<Integer> visited) {
        visited.add(node);

        result[node] = parentSum - sumToRoot[node][0] + result.length - sumToRoot[node][0];

        for (int child : map.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(child)) {
                getAllNodesSum(map, sumToRoot, child, result, result[node], visited);
            }
        }
    }
}
