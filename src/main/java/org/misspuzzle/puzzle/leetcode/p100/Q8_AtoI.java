package org.misspuzzle.puzzle.leetcode.p100;

public class Q8_AtoI {
	
    public int myAtoi(String str) {
        str = str.trim();
        
        if (str.length() == 0) {
        	return 0;
        }
        
        boolean isPositive = true;
        
        if (str.charAt(0) == '-') {
        	isPositive = false;
        	
        	str = str.substring(1);
        } else if (str.charAt(0) == '+') {
        	str = str.substring(1);
        }
        
        for (int i = 0; i < str.length(); i++) {
        	if (str.charAt(i) < '0' || str.charAt(i) > '9') {
        		str = str.substring(0, i);
        		break;
        	}
        }
        
        if (str.length() == 0) {
        	return 0;
        }
    	
        if (str.length() > 10) {
        	return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (str.length() == 10) {
            char[] maxInt = {'2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
            
            if (isPositive) {
            	maxInt[9] = '7';
            }
            
            boolean isOverflow = false;
            
            for (int i = 0; i < str.length(); i++) {
        		if (str.charAt(i) > maxInt[i]) {
        			isOverflow = true;
        			break;
        		} else if (str.charAt(i) < maxInt[i]) {
        			break;
        		}
            }
        	
            if (isOverflow) {
            	return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        
    	return Integer.parseInt((isPositive ? "" : "-") + str.toString());
    }
}
