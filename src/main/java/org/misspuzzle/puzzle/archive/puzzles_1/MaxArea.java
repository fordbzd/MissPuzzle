package org.misspuzzle.puzzle.archive.puzzles_1;

public class MaxArea{

    public int maxArea(int[] height) {
    
    	int max = 0;
    	int tempMax = 0;
    	
    	int first = 0;
    	int last = height.length - 1;
    	
    	int h1 = 0;
    	int h2 = 0;
    	
    	while (last > first) {
    		h1 = height[first];
    		h2 = height[last];
    		
    		tempMax = (h1 > h2 ? h2 : h1) * (last - first);
    		
    		max = tempMax > max ? tempMax : max;
    		
    		if (h2 > h1) {
    			first++;
    		} else {
    			last--;
    		}
    	}
    	
    	return max;
    }
}
