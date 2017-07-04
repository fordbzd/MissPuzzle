package puzzles_1;

import interfaces.Puzzle;

public class SumToPalindrome implements Puzzle {

	@Override
	public void execute() {
		System.out.println(getSteps(15));
		
	}
	
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
