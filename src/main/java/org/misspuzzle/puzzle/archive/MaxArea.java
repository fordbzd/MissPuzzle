package org.misspuzzle.puzzle.archive;

public class MaxArea{

    public int maxArea(int[] height) {
    
    	int max = 0;
    	int tempMax;
    	
    	int first = 0;
    	int last = height.length - 1;
    	
    	int h1;
    	int h2;
    	
    	while (last > first) {
    		h1 = height[first];
    		h2 = height[last];
    		
    		tempMax = Math.min(h1, h2) * (last - first);
    		
    		max = Math.max(tempMax, max);
    		
    		if (h2 > h1) {
    			first++;
    		} else {
    			last--;
    		}
    	}
    	
    	return max;
    }
}
