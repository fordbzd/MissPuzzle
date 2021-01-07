package org.misspuzzle.puzzle.archive.puzzles_3;

import java.util.PriorityQueue;


public class FindKthLargest {
	
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for (int num : nums) {
        	queue.offer(num);
        	
        	if (queue.size() > k) {
        		queue.poll();
        	}
        }
    	
    	return queue.peek();
    	
    }
}
