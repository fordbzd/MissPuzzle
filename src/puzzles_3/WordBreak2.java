package puzzles_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import interfaces.Puzzle;

public class WordBreak2 implements Puzzle {

	@Override
	public void execute() {
		List<String> wordDict = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});

		for (String sentence : wordBreak("catsanddog", wordDict)) {
			System.out.println(sentence);
		}
	}
	
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, "", new ArrayList<String>());
    }

    private List<String> dfs(String s, List<String> wordDict, String sentence, List<String> result) {

    	String newSen = "";
    	
    	for (String word : wordDict) {
    		if (s.startsWith(word)) {
    			newSen = sentence + (sentence.length() == 0 ? word : (" " + word));
    			
    			if (s.length() == word.length()) {
    				result.add(newSen);
    			} else {
    				dfs(s.substring(word.length(), s.length()), wordDict, newSen, result);
    			}
    		}
    	}
    	
    	return result;
    }
}
