package puzzles_2;

import java.util.Arrays;
import java.util.List;

import interfaces.Puzzle;

public class WordBreak implements Puzzle {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
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
