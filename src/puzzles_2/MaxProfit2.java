package puzzles_2;

import interfaces.Puzzle;

public class MaxProfit2 implements Puzzle {

	@Override
	public void execute() {
		System.out.println(maxProfit(new int[]{0, 1, 5, 3, 6, 4, 6}));

	}

    public int maxProfit(int[] prices) {
    	if (prices.length < 1 ) {
    		return 0;
    	}
    	
        int sum = 0;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] < prices[i - 1]) {
        		sum += prices[i - 1] - min;
        		
        		min = prices[i];
        	}
        }
    	
        sum += prices[prices.length - 1] - min;
        
    	return sum;
    }
}
