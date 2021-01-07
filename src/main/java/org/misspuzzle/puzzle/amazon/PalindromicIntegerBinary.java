package org.misspuzzle.puzzle.amazon;

public class PalindromicIntegerBinary {
	
	public boolean isPalindromic(int n) {
		char[] s = Integer.toBinaryString(n).toCharArray();
		
		int start = 0;
		int end = s.length - 1;
		
		while(start <= end) {
			if (s[start++] != s[end--]) {
				return false;
			}
		}
		
		return true;
		
		
	}
	
	public static String toFullBinaryString(int num) {  
	     char[] chs = new char[Integer.SIZE];  
	     for(int i = 0; i < Integer.SIZE; i++) {  
	         chs[Integer.SIZE - 1 - i] = (char)(((num >> i) & 1) + '0');  
	     }  
	     return new String(chs);          
	 }  

}
