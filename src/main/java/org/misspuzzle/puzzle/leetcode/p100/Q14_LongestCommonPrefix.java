package org.misspuzzle.puzzle.leetcode.p100;

public class Q14_LongestCommonPrefix {
	
    public String longestCommonPrefix(String[] strs) {
    	if (strs.length == 0) {
    		return "";
    	}
    	
        StringBuilder common = new StringBuilder();
        
        boolean hasCommon = true;
    	
    	for (int i = 0; i < strs[0].length(); i++) {
    		common.append(strs[0].charAt(i));
    		
    		for (int j = 0; j < strs.length; j++) {
    			if (!strs[j].startsWith(common.toString())) {
    				hasCommon = false;
    				break;
    			}
    		}
    		
    		if (!hasCommon) {
    			break;
    		}
     	}
    	
    	return hasCommon ? common.toString() : common.substring(0, common.length() - 1);
    }

}
