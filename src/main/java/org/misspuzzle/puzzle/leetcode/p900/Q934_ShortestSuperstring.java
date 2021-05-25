package org.misspuzzle.puzzle.leetcode.p900;

import java.util.HashMap;
import java.util.Map;

public class Q934_ShortestSuperstring {
    public String shortestSuperstring(String[] words) {
        int[][] graph = new int[words.length][words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    graph[i][j] = getDuplicate(words[i], words[j]);
                }
            }
        }

        return dfs(graph, words, new boolean[words.length], -1, new HashMap<>());
    }

    private String dfs(int[][] graph, String[] words, boolean[] visit, int last, Map<String, String> cache) {
        int postfix = 0;
        for (int i = 0; i < visit.length; i++) {
            postfix += visit[i] ? 0 : (1 << i);
        }
        String key = last + "-" + postfix;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (!visit[i]) {
                visit[i] = true;

                String next = (last > -1 ? words[i].substring(graph[last][i]) : words[i]) + dfs(graph, words, visit, i, cache);
                result = (result.length() == 0 || result.length() > next.length()) ? next : result;

                visit[i] = false;
            }
        }

        cache.put(key, result);

        return result;
    }


    private int getDuplicate(String word1, String word2) {
        for (int i = word1.length() - Math.min(word1.length(), word2.length()); i < word1.length(); i++) {
            if (word2.startsWith(word1.substring(i))) {
                return word1.length() - i;
            }
        }

        return 0;
    }
}
