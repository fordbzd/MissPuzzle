package org.misspuzzle.puzzle.archive;

public class SumToPalindrome {
	
	public int getSteps(int n) {
		int step = 0;
		boolean isPalindrome = false;
		
		do {
			step++;
			
			String strN = String.valueOf(n);
			strN = new StringBuffer(strN).reverse().toString();
			
			int reverseN = Integer.parseInt(strN);
			
			String sum = String.valueOf(n + reverseN);
			
			isPalindrome = sum.equals(new StringBuilder(sum).reverse().toString());
			
			n = n + reverseN;
			
		} while (!isPalindrome);
		
		return step;
	}

}
