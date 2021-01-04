package org.misspuzzle.puzzle.archive.puzzles_1;

import org.misspuzzle.puzzle.Puzzle;

public class MaxSubSum_DP implements Puzzle {

	int[] a = {2, -4, 6, 8, 9, 7, -6, -7, 8, 10, -2};
	int n = a.length;
	int[] s = new int[n];
	int[] t = new int[n];
	
	@Override
	public void execute() {
		
		s[n - 1] = maxSubSum(n - 1);
		
		int max = Integer.MIN_VALUE, startP = 0, endP = 0; 
		for(int i = 0; i < n; ++i) {
			if(max < s[i]) {
				max = s[i];
				startP = t[i];
				endP = i;
			}
		}
		
		for(int i = startP; i <= endP; ++i) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		System.out.println("Sum = " + s[endP]);
	}

	
	private int maxSubSum(int x) {
		if(x == 0){
			s[0] = a[0];
			t[0] = 0;
			return s[0];
		} else {
			s[x] = maxSubSum(x - 1) + a[x];
			if(s[x] >= a[x]) {
				t[x] = t[x -1];
				return s[x];
			} else {
				s[x] = a[x];
				t[x] = x;
				return s[x];						 
			}
		}
	}
}
