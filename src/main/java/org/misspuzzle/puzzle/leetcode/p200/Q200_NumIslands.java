package org.misspuzzle.puzzle.leetcode.p200;

import org.misspuzzle.datastructure.Point;

import java.util.Stack;


public class Q200_NumIslands {
	
    public int numIslands(char[][] grid) {
    	
    	if (grid.length == 0) {
    		return 0;
    	}
        
    	Stack<Point> visit = new Stack<Point>();
    	
    	int[][] direction = new int[][] {
    			{0, 0, 1, -1},
    			{-1, 1, 0, 0}
    	};
    	
    	int sum = 0;
    	
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == '1') {
    				visit.push(new Point(i, j));
    				
    				sum++;
    				
    				while (visit.size() > 0) {
    					Point p = visit.pop();
    					
    					if (grid[p.x][p.y] == '0') {
    						continue;
    					}
    					
    					grid[p.x][p.y] = '0';
    					
    					for (int k = 0; k < 4; k++) {
    						int nextX = p.x + direction[0][k];
    						int nextY = p.y + direction[1][k];
    						
    						if (nextX >= 0 && nextX < grid.length &&
    								nextY >= 0 && nextY < grid[0].length &&
    								grid[nextX][nextY] == '1') {
    							visit.push(new Point(nextX, nextY));
    						}
    					}
    				}
    			}
    			
    		}
    	}
    	
    	return sum;
    	
    }

}
