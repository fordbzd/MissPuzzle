package org.misspuzzle.puzzle.leetcode.p000;

public class Q26_RemoveDuplicates {
	
    public int removeDuplicates(int[] nums) {
		int n = nums.length;

		if (n < 2)
			return n;
		
		int id = 1;
		
		for (int i = 1; i < n; ++i)
			if (nums[i] != nums[i - 1])
				nums[id++] = nums[i];
		return id;
    }

}
