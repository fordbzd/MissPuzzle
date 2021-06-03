package org.misspuzzle.puzzle.leetcode.p1200;

import java.util.*;

public class Q1268_SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        HeapTrie root = new HeapTrie();

        buildTrie(root, products);

        List<List<String>> result = new ArrayList<>();

        HeapTrie node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            if (node == null) {
                result.add(new ArrayList<>());
                continue;
            }

            node = node.map.get(searchWord.charAt(i));

            if (node == null) {
                result.add(new ArrayList<>());
                continue;
            }

            List<String> top3 = new ArrayList<>(node.heap);
            top3.sort(String::compareTo);

            result.add(top3);
        }

        return result;
    }

    private void buildTrie(HeapTrie root, String[] words) {

        for (String word: words) {
            HeapTrie node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!node.map.containsKey(c)) {
                    node.map.put(c, new HeapTrie());
                }

                node = node.map.get(c);
                node.calculateTop3(word);
            }
        }
    }

    static class HeapTrie {
        Map<Character, HeapTrie> map;
        PriorityQueue<String> heap;

        HeapTrie() {
            map = new HashMap<>();
            heap = new PriorityQueue<>((a, b) -> (-a.compareTo(b)));
        }

        void calculateTop3(String word) {
            heap.offer(word);

            if (heap.size() > 3) {
                heap.poll();
            }
        }
    }
}
