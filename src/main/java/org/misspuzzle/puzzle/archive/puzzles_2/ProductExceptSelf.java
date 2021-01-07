package org.misspuzzle.puzzle.archive.puzzles_2;

public class ProductExceptSelf {
	
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        
    	if (nums.length == 0) {
    		return result;
    	}
        
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
        	result[i] = nums[i - 1] * result[i - 1];
        }
        
        int right = 1;
        for (int i = nums.length - 1; i >=0; i--) {
        	result[i] = result[i] * right;
        	right = nums[i] * right;
        }
        
        return result;
    }

}
