package org.misspuzzle.puzzle.archive.puzzles_1;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayList;

public class EvenSum implements Puzzle {
	
	public void execute() {
		
		int[] test = {10, 20, 30, 5 , 40, 50, 40, 15, 13};
		
		try {
			int[][] a = splitEvenly(test);
			
			for(int i = 0; i < a[0].length; i++)
				System.out.print(a[0][i] + " ");
			
			System.out.println();
			
			for(int i = 0; i < a[1].length; i++)
				System.out.print(a[1][i] + " ");
			
			System.out.println();
			
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		

	}
	
	public int[][] splitEvenly(int[] integerList) throws InvalidInputException {
	    
	    int sum = 0,
	    	n = integerList.length;
	    
	    if(n < 2)
	    	throw new InvalidInputException();
	    
	    for(int i = 0; i < n; i++) {
	    	sum += integerList[i];
	    }
	    
	    ArrayList<Integer> result = findSubList(integerList, 0, n, sum / 2, new ArrayList<Integer>());
	    
	    int[][] splitLists = new int[2][];
	    splitLists[0] = new int[result.size()];
	    splitLists[1] = new int[n - result.size()];
	    
	    int k = 0, j = 0;
	    
	    for(int i = 0; i < n; i++) {
	    	if(result.contains(integerList[i])) {
	    		splitLists[0][k++] = integerList[i];
	    		result.remove(new Integer(integerList[i]));
	    	}
	    	else
	    		splitLists[1][j++] = integerList[i];
	    }
	    
	    return splitLists;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Integer> findSubList(int[] integerList, int index, int n, int semiSum, ArrayList<Integer> currList) {
		if(index == n) {			
			return (ArrayList<Integer>) currList.clone();
		}
		
		currList.add(integerList[index]);
		ArrayList<Integer> r1 = findSubList(integerList, index + 1, n, semiSum, currList);
		
		currList.remove(currList.size() - 1);
		ArrayList<Integer> r2 = findSubList(integerList, index + 1, n, semiSum, currList);
		
		if(Math.abs(semiSum - getArraySum(r1)) > Math.abs(semiSum - getArraySum(r2)))
			return r2;
		else 
			return r1;
	}
	
	private int getArraySum(ArrayList<Integer> a) {
		int sum = 0;
	    
	    for(int i = 0; i < a.size(); i++) {
	    	sum += a.get(i);
	    }
	    
	    return sum;
	}
	
	class InvalidInputException extends Exception {

		private static final long serialVersionUID = 1L;
		
	}

}
