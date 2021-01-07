package org.misspuzzle.puzzle.amazon;

import java.util.Stack;

public class ValidParenthesis {
	
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int pos = 0;
        
        char[] left = {'(', '[', '{'};
        char[] right = {')', ']', '}'};
        
        for(char c : s.toCharArray()) {
        	if (indexOf(left, c) != -1) {
        		stack[pos] = c;
        		pos++;
        	} else {
        		int index = indexOf(right, c);
        		
        		if (pos != 0 && stack[pos - 1] == left[index]) {
        			pos--;
        		} else {
        			return false;
        		}
        	}
        }
        
    	return pos == 0;
    }
    
    private int indexOf(char[] arr, char toCompare) {
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == toCompare) {
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    public boolean isValid2(String s) {
        Stack<String> p = new Stack<String>();
        
        String[] left = {"(", "[", "{"};
        String[] right = {")", "]", "}"};
        
        for(int i = 0; i < s.length(); i++) {
        	String sub = s.substring(i, i+1);
        	
        	if (indexOf(left, sub) != -1) {
        		p.push(sub);
        	} else {
        		int index = indexOf(right, sub);
        		
        		if (p.size() != 0 && p.peek().equalsIgnoreCase(left[index])) {
        			p.pop();
        		} else {
        			return false;
        		}
        	}
        }
        
    	return p.size() == 0;
    }
    
    private int indexOf(String[] arr, String toCompare) {
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i].equalsIgnoreCase(toCompare)) {
    			return i;
    		}
    	}
    	
    	return -1;
    }

}
