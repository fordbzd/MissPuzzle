package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring implements Puzzle {

	@Override
	public void execute() {
		String[] words = {"word","good","best","good"};
		
		System.out.println(findSubstring("wordgoodgoodgoodbestword", words));

	}
	
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        
        int length = words[0].length();
        
        Map<String, Integer> counts = new HashMap<String, Integer>();
        
        for (String word : words) {
        	Integer count = counts.get(word);
        	
        	counts.put(word, count == null ? 1 : count + 1);
        }
        
        for (int i = 0; i < length; i++) {
        	Map<String, Integer> countsCopy = new HashMap<String, Integer>(counts); 
        	
        	int left = i;
        	int right = i;
        	int occurrence = 0;
        	
        	while (right <= (s.length() - length)) {
        		while (right <= s.length() - length && occurrence != words.length) {
        			String substring = s.substring(right, right + length);
        			Integer wordCount = countsCopy.get(substring);
        			
        			if (wordCount != null) {
        				if (wordCount > 0) {
        					occurrence++;
        				}
        				countsCopy.put(substring, wordCount - 1);
        			}
        			
        			right += length;
        		}
        		
        		while (occurrence == words.length && left < right) {
        			if (right - left == words.length * length) {
        				result.add(left);
        			}
        			
        			String substring = s.substring(left, left + length);
        			Integer wordCount = countsCopy.get(substring);
        			
        			if (wordCount != null) {
        				countsCopy.put(substring, wordCount + 1);
        				if (wordCount >= 0) {
        					occurrence--;
        				}
        			}
        			
        			left += length;
        		}
        	}
        }
        
    	return result;
    	
    }

}
