package puzzles_amazon;

import interfaces.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams implements Puzzle {

	@Override
	public void execute() {
		System.out.println(findAnagrams("cbaebabacd", "abc"));

	}
	
    public List<Integer> findAnagrams(String s, String p) {
    	
    	List<Integer> result = new ArrayList<Integer>();
    	
    	if (p.length() > s.length()) {
    		return result;
    	}
    	
        int[] pCount = new int[256];
        
        for (char c : p.toCharArray()) {
        	pCount[c]++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while(right < s.length()) {
        	pCount[s.charAt(right)]--;
        	
        	if (pCount[s.charAt(right)] >= 0) {
        		count--;
        	}
        	
        	if (count == 0) {
        		result.add(left);
        	}
        	
        	right++;
        	
        	if (right - left == p.length()) {
        		pCount[s.charAt(left)]++;
        		
        		if (pCount[s.charAt(left)] > 0) {
        			count++;
        		}
        		
        		left++;
        	}
        }
        
        return result;
        
    }
}
