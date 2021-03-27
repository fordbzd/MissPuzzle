package org.misspuzzle.puzzle.leetcode.p200;

import java.util.PriorityQueue;


public class Q215_FindKthLargest {
	
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
