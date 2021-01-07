package org.misspuzzle.puzzle.archive.puzzles_2;

public class MaxProfit {
	
    public int maxProfit(int[] prices) {
    	if (prices.length < 1) {
    		return 0;
    	}
    	
        int max = 0;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
        	int price_i = prices[i];
        	int diff = price_i - min;
        	
        	if (price_i > min && diff > max) {
        		max = diff;
        	}
        	
        	if (price_i < min) {
        		min = price_i;
        	}
        }
        
        return max;
    }

}
