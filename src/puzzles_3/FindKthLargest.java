package puzzles_3;

import java.util.PriorityQueue;

import interfaces.Puzzle;

public class FindKthLargest implements Puzzle {

	@Override
	public void execute() {
		System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3));

	}
	
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
