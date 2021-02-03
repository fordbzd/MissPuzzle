package org.misspuzzle.puzzle.leetcode.p300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html
 */
public class Q269_AlienOrder {
	
	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> edgeMap = new HashMap<Character, Set<Character>>();
		Set<Character> points = new HashSet<Character>();
		
		int[] edgeCount = new int[26];
		
		// Compare char and build graph.
		for (int i = 0; i < words.length - 1; i++) {
			for (char c : words[i].toCharArray()) {
				points.add(c);
			}
			
			for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
				char c1 = words[i].charAt(j);
				char c2 = words[i + 1].charAt(j);
				
				// If c1 > c2.
				if (c1 != c2) {
					Set<Character> childEdge = edgeMap.get(c1);
					
					if (childEdge == null) {
						childEdge = new HashSet<Character>();
						edgeMap.put(c1, childEdge);
					}
					
					childEdge.add(c2);
					
					edgeCount[c2 - 'a']++;
					
					break;
				}
			}
		}
		
		// Topological Sort.
		Queue<Character> queue = new PriorityQueue<Character>();
		
		for (char c : edgeMap.keySet()) {
			if (edgeCount[c - 'a'] == 0) {
				queue.offer(c);
			}
		}
		
		StringBuilder result = new StringBuilder();
		
		while (queue.size() > 0) {
			char p = queue.poll();
			
			result.append(p);
			
			Set<Character> childEdge = edgeMap.get(p);
			if (childEdge != null) {
				for (char c : childEdge) {
					if (--edgeCount[c - 'a'] == 0) {
						queue.offer(c);
					}
				}
			}
			
			
		}
		
		return (queue.size() > 0) ? "" : result.toString();
	}

}
