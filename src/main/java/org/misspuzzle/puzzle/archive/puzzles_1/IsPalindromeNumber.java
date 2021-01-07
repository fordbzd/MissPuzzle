package org.misspuzzle.puzzle.archive.puzzles_1;

public class IsPalindromeNumber {
	
    public boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	}
    	
    	int[] tens = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        int digit = 9;
        
        for (int i = digit; i >= 0; i--) {
        	if (x / tens[i] > 0) {
        		digit = i;
        		break;
        	}
        }
        
        while (digit > 0) {
        	int first = x / tens[digit];
        	int last = x % 10;
        	
        	if (first != last) {
        		return false;
        	}
        	
        	x = x - first * tens[digit];
        	x = x / 10;
        	
        	digit -= 2;
        }
        
        return true;
    }
    
}
