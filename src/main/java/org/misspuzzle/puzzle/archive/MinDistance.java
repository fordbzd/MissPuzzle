package org.misspuzzle.puzzle.archive;

public class MinDistance {
	
    public int minDistance(String word1, String word2) {
        
    	int[] dp = new int[word2.length() + 1];
    	
    	for (int j = 0; j <= word2.length(); j++) {
    		dp[j] = j;
    	}
    	
    	for (int i = 1; i <= word1.length(); i++) {
    		int pre = dp[0];
    		dp[0] = i;
    		
    		for (int j = 1; j <= word2.length(); j++) {
    			int temp = dp[j];
    			
    			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    				dp[j] = pre;
    			} else {
    				dp[j] = Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
    			}
    			
    			pre = temp;
    		}
    	}
    	
    	return dp[word2.length()];
    }
	
    public int minDistance2(String word1, String word2) {
        
    	int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    	
    	for (int i = 0; i <= word1.length(); i++) {
    		dp[i][0] = i;
    	}
    	
    	for (int j = 0; j <= word2.length(); j++) {
    		dp[0][j] = j;
    	}
    	
    	for (int i = 1; i <= word1.length(); i++) {
    		for (int j = 1; j <= word2.length(); j++) {
    			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    				dp[i][j] = dp[i - 1][j - 1];
    			} else {
    				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
    			}
    		}
    	}
    	
    	return dp[word1.length()][word2.length()];
    }

}
