package org.misspuzzle.puzzle.archive.puzzles_1;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum implements Puzzle {

	@Override
	public void execute() {
		int[] s = {-1, 0, 1, 2, -1, -4};
		
		for (List<Integer> list : threeSum(s)) {
			System.out.println(list);
		}
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        if (nums.length < 3) {
        	return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i == 0 || nums[i] != nums[i - 1]) {
        		int sum = 0 - nums[i];
        		int left = i + 1;
        		int right = nums.length - 1;
        		
        		while (left < right) {
        			int tempSum = nums[left] + nums[right];
        			if (tempSum == sum) {
        				result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
        				while ((left < nums.length - 1) && (nums[left] == nums[++left])) {}
        				while ((right > 0) && (nums[right] == nums[--right])) {}
        			} else if (tempSum > sum) {
        				right--;
        			} else {
        				left++;
        			}
        		}
        	}
        }
        
        return result;
    }

}
