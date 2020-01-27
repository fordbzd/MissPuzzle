package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

public class MaxProfit implements Puzzle {

	@Override
	public void execute() {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

	}
	
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
