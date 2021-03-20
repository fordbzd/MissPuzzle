package org.misspuzzle.puzzle.leetcode.p900;

import java.util.List;

public class Q841_CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        for (int i = 0; i < rooms.size(); i++) {
            if (visited[i]) {
                dfs(rooms, i, visited);
            }
        }

        for (boolean record : visited) {
            if (!record) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited) {
        for (int key : rooms.get(i)) {
            if (!visited[key]) {
                visited[key] = true;
                dfs(rooms, key, visited);
            }
        }
    }
}
