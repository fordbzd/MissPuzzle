package org.misspuzzle.puzzle.archive.puzzles_1;

import org.misspuzzle.puzzle.Puzzle;
public class MedianSortedArrays implements Puzzle {

	@Override
	public void execute() {
		int[] nums1 = {1, 3, 5, 7, 9};
		int[] nums2 = {0, 2, 4, 6, 8};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
        	return findMedianSortedArrays(nums2, nums1);
        }
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        if (l1 == 0) {
        	return (nums2[l2 / 2] + nums2[(l2 - 1) / 2]) / 2.0;
        }
        
        int left = 0;
        int right = l1;
        int i = 0;
        int j = 0;      
        int max, min;
        
        while (left <= right) {
        	i = (left + right) / 2;
        	j = (l1 + l2 + 1) / 2 - i;
        	
        	if (i > 0 && nums1[i - 1] > nums2[j]) {
        		right = i - 1;
        	} else if (i < l1 && nums1[i] < nums2[j - 1]) {
        		left = i + 1;
        	} else {
        		if (i == 0) {
        			max = nums2[j - 1];
        		} else if (j == 0) {
        			max = nums1[i - 1];
        		} else {
        			max = Math.max(nums1[i - 1], nums2[j - 1]);
        		}
        		
        		if ((l1 + l2) % 2 == 1) {
        			return max;
        		}
        		
        		if (i == l1) {
        			min = nums2[j];
        		} else if (j == l2) {
        			min = nums1[i];
        		} else {
        			min = Math.min(nums1[i], nums2[j]);
        		}
        		
        		return (min + max) / 2.0;
        	}
        }
        
        return 0.0;
    }

}