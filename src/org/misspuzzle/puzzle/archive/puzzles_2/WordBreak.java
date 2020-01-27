package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

import java.util.Arrays;
import java.util.List;


public class WordBreak implements Puzzle {

	@Override
	public void execute() {
		String s = "aaaaaaaa";
		
		List<String> wordDict = Arrays.asList(new String[]{"aaaa", "aa", "a"});
		
		System.out.println(wordBreak(s, wordDict));

	}
	
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;   
        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    	
    }

}
