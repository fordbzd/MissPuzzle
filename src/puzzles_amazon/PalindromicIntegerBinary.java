package puzzles_amazon;

import interfaces.Puzzle;

public class PalindromicIntegerBinary implements Puzzle {

	@Override
	public void execute() {
		System.out.println(isPalindromic(10));

	}
	
	public boolean isPalindromic(int n) {
		System.out.println(n + " -> " + Integer.toBinaryString(n));
		
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
