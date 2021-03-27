package org.misspuzzle.puzzle.leetcode.p0;

public class Q63_UniquePath2 {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
    	int[] step = new int[m];
    	
    	boolean hasPath = true;
    	for (int i = 0; i < m; i++) {
    		hasPath = hasPath && (obstacleGrid[i][0] == 0);
    		step[i] = hasPath ? 1 : 0;
    	}
    	
    	hasPath = obstacleGrid[0][0] == 0;
    	for (int i = 1; i < n; i++) {
    		hasPath = hasPath && obstacleGrid[0][i] == 0;
    		step[0] = hasPath ? 1 : 0;
    		
    		for (int j = 1; j < m; j++) {
    			step[j] = obstacleGrid[j][i] == 0 ? (step[j - 1] + step[j]) : 0;
    		}
    	}
    	
    	return step[m - 1];
    	
    	
    }

}
