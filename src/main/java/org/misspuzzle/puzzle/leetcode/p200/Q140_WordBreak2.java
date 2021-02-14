package org.misspuzzle.puzzle.leetcode.p200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q140_WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, new HashSet<>(wordDict), new HashMap<>());
	}

	private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}

		List<String> list = new LinkedList<>();

		for (String word : wordDict) {

			if (word.equalsIgnoreCase(s)) {
				list.add(word);
			} else if (s.startsWith(word)) {
				List<String> subList = dfs(s.substring(word.length()), wordDict, map);

				for (String sub: subList) {
					list.add(word + " " + sub);
				}
			}
		}

		map.put(s, list);

		return list;
	}


	////////////////////// Attempt 2 //////////////////////

	public List<String> wordBreak_attempt2(String s, List<String> wordDict) {

		Set<String> dictSet = new HashSet<>(wordDict);
		List<List<String>> dp = new ArrayList<>();
		dp.add(new LinkedList<>());

		for (int i = 0; i < s.length(); i++) {
			List<String> newSentence = new LinkedList<>();
			dp.add(newSentence);

			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);

				if (dictSet.contains(sub)) {
					if (j == 0) {
						newSentence.add(sub);
					} else {
						for (String sentence : dp.get(j)) {
							newSentence.add(sentence + " " + sub);
						}
					}
				}
			}
		}

		return dp.get(s.length());
	}

	////////////////////// Attempt 1 //////////////////////

    public List<String> wordBreak_attempt1(String s, List<String> wordDict) {
        return dfs_attempt1(s, wordDict, "", new ArrayList<>());
    }

    private List<String> dfs_attempt1(String s, List<String> wordDict, String sentence, List<String> result) {

    	String newSen = "";
    	
    	for (String word : wordDict) {
    		if (s.startsWith(word)) {
    			newSen = sentence + (sentence.length() == 0 ? word : (" " + word));
    			
    			if (s.length() == word.length()) {
    				result.add(newSen);
    			} else {
    				dfs_attempt1(s.substring(word.length(), s.length()), wordDict, newSen, result);
    			}
    		}
    	}
    	
    	return result;
    }
}
