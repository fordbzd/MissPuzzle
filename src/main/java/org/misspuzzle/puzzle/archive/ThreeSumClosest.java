package org.misspuzzle.puzzle.archive;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
        
        if (nums.length < 3) {
        	return 0;
        }
        
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i == 0 || nums[i] != nums[i - 1]) {
        		int left = i + 1;
        		int right = nums.length - 1;
        		
        		while (left < right) {
        			int sum = nums[i] + nums[left] + nums[right];
        			
        			if (Math.abs(sum - target) < Math.abs(min - target)) {
        				min = sum;
        			}    			
        			
        			if (sum > target) {
        				right--;
        			} else {
        				left++;
        			}
        		}
        	}
        }
        
        return min;
    }

}
