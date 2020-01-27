package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

public class UniquePath implements Puzzle {

	@Override
	public void execute() {
		System.out.println(uniquePaths(7, 3));

	}
	
    public int uniquePaths(int m, int n) {
    	int[] step = new int[m];
    	
    	for (int i = 0; i < m; i++) {
    		step[i] = 1 ;
    	}
    	
    	for (int i = 1; i < n; i++) {
    		for (int j = 1; j < m; j++) {
    			step[j] = step[j - 1] + step[j];
    		}
    	}
    	
    	return step[m - 1];
    }

}
