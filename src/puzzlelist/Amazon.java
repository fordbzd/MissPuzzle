package puzzlelist;

import interfaces.PuzzleList;

public class Amazon implements PuzzleList {
	public String[] getPuzzleList() {
		return new String[] { 
				"ValidParenthesis", 
				"FindAnagrams",
				"PalindromicIntegerBinary", 
				"MazeShortestStep",
				"LowestCommonAncestor", 
				"BaseballScore", 
				"CommonManager",
				"SimilarMovies", 
				"BFSDistance" 
		};
	}
	
	public String getPackageName() {
		return "puzzles_amazon.";
	}
}
