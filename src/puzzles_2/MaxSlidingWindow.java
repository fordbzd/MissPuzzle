package puzzles_2;

import java.util.ArrayDeque;
import java.util.Deque;

import interfaces.Puzzle;

public class MaxSlidingWindow implements Puzzle {

	@Override
	public void execute() {
		
		int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
		
		for (int n : maxSlidingWindow(nums, 3)) {
			System.out.println(n);
		}
	}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
        	return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	while (!deque.isEmpty() && deque.peek() < (i + 1 - k)) {
        		deque.poll();
        	}
        	
        	while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        		deque.pollLast();
        	}
        	
        	deque.offer(i);
        	
        	if (i >= k - 1) {
        		result[i - k + 1] = nums[deque.peek()];
        	}
        	
        	
        }
        
        return result;
    	
    	
    	
    }

}
