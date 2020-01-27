package org.misspuzzle.puzzle.leetcode;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class Q6_ZigZagConversion implements Puzzle {

	@Override
	public void execute() {

		System.out.println(convert("PAYPALISHIRING", 200));

	}
	
    public String convert(String s, int numRows) {
    	if (numRows == 1 || numRows >= s.length()) {
    		return s;
    	}
    	
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        
        for (int i = 0; i < numRows; i++) {
        	rows.add(new StringBuilder());
        }
        
        int row = 0;
        int count = 0;
        boolean isZ = false;
        
        while (count < s.length()) {
        	String c = s.substring(count, count + 1);
        	
//        	System.out.println(row);
        	
        	rows.get(row).append(c);
        	
        	if (isZ) {
        		row--;
        		
        		if (row == 0) {
        			isZ = false;
        		}
        	} else {
        		row++;
        		
        		if (row == numRows) {
        			row -= 2;
        			if (numRows > 2) {
        				isZ = true;
        			}
        		}
        	}
        	
        	count++;
        }
        
        String result = "";
        
        for (StringBuilder sb : rows) {
//        	System.out.println(sb.toString());
        	
        	result += sb.toString();
        }
        
        return result;
    }

}
