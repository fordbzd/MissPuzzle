package puzzles_3;

import interfaces.Puzzle;

public class UpdateMatrix implements Puzzle {

	@Override
	public void execute() {
		int[][] matrix = {
				{1, 1, 1, 0},
				{1, 1, 0, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 0, 1}
		};
		
		matrix = updateMatrix(matrix);
		
		for (int[] row : matrix) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			
			System.out.println();
		}

	}
	
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = Math.max(m, n);
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] != 0) {
        			if (i == 0 && j == 0) {
        				matrix[0][0] = max;
        			} else {
        				int top = i == 0 ? max : matrix[i - 1][j];
        				int left = j == 0 ? max : matrix[i][j - 1];
        				
        				matrix[i][j] = Math.min(top, left) + 1;
        			}
        		}
        		
        	}
        }
    	
        for (int i = m - 1; i >= 0; i--) {
        	for (int j = n - 1; j >= 0; j--) {
        		if (matrix[i][j] != 0) {
        			if (i == m - 1 && j == n - 1) {
        				continue;
        			} else {
        				int bottom = (i == m - 1) ? max : matrix[i + 1][j];
        				int right = (j == n - 1) ? max : matrix[i][j + 1];
        				
        				matrix[i][j] = Math.min(matrix[i][j], Math.min(bottom, right) + 1);
        			}
        		}
        		
        	}
        }
    	
    	return matrix;
    }

}
