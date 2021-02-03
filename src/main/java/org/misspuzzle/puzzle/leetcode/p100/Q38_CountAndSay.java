package org.misspuzzle.puzzle.leetcode.p100;

public class Q38_CountAndSay {
	
    public String countAndSay(int n) {
        if (n == 1) {
        	return "1";
        }
        
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        sb.append('1');
        
        for (int i = 1; i < n; i++) {
        	
        	char c = sb.charAt(0);
        	int count = 1;
        	
        	for (int j = 1; j < sb.length(); j++) {
        		if (sb.charAt(j) != c) {
        			result.append((char)('0' + count));
        			result.append(c);
        			
        			c = sb.charAt(j);
        			count = 1;
        		} else {
        			count++;
        		}
        	}
        	
			result.append((char)('0' + count));
			result.append(c);
        	
			sb = result;
			result = new StringBuilder();
        	
        }
    
    	return sb.toString();
    }

}
