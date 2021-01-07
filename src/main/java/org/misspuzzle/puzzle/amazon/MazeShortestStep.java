package org.misspuzzle.puzzle.amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class MazeShortestStep {
	
	public int findShortestStep(int[][] maze, int m, int n, int x, int y) {
		
		Queue<Cood> queue = new ArrayDeque<Cood>();
		
		queue.add(new Cood(0, 0, 0));
		
		int[][] nextStep = {
				{1, 0},
				{0, 1},
				{-1, 0},
				{0, -1}
		};
		
		boolean[][] visited = new boolean[m][n];
		
		while (queue.size() > 0) {
			Cood c = queue.poll();
			
			if (c.x == x && c.y == y) {
				return c.level + 1;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = c.x + nextStep[i][0];
				int nextY = c.y + nextStep[i][1];
				
				if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n &&
						maze[nextX][nextY] != -1 && !visited[nextX][nextY]) {
					
					queue.add(new Cood(nextX, nextY, c.level + 1));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return -1;
		
	}
	
	class Cood {
		int x;
		int y;
		int level;
		Cood(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}

}
