package org.misspuzzle.puzzle.archive.puzzles_1;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination implements Puzzle {

	@Override
	public void execute() {
		System.out.println(letterCombinations("23"));

	}
	
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	
    	if (digits.length() == 0) {
    		return result;
    	}
        
        char[][] keyboard = {
        		{' '},
        		{},
        		{'a','b', 'c'},
        		{'d', 'e', 'f'},
        		{'g', 'h', 'i'},
        		{'j', 'k', 'l'},
        		{'m', 'n', 'o'},
        		{'p', 'q', 'r', 's'},
        		{'t', 'u', 'v'},
        		{'w', 'x', 'y', 'z'}
        };
        
        char[] input = digits.toCharArray();
        
        combine(new StringBuilder(), result, input, keyboard, 0);
        
        return result;
    }
    
    private void combine(StringBuilder sb, List<String> result, char[] input, char[][] keyboard, int index) {
    	for (char c : keyboard[input[index] - '0']) {
    		sb.append(c);
    		
    		if (index == input.length - 1) {
    			result.add(sb.toString());
    		} else {
    			combine(sb, result, input, keyboard, index + 1);
    		}
    		
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	
    	if (keyboard[input[index] - '0'].length == 0 && index < input.length - 1) {
    		combine(sb, result, input, keyboard, index + 1);
    	}
    	
    	
    }

}
