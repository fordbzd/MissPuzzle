package org.misspuzzle.puzzle.leetcode.p500;

import org.misspuzzle.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q508_FindFrequentTreeSum {
	
    public int[] findFrequentTreeSum(TreeNode root) {
    	if (root == null) {
    		return new int[0];
    	}
    	
    	
    	Map<Integer, Integer> frequents = new HashMap<Integer, Integer>();
    	
    	tranverseTree(root, frequents);
    	
    	int max = 0;
    	
    	for (Integer key : frequents.keySet()) {
    		if (frequents.get(key) > max) {
    			max = frequents.get(key);
    		}
    	}
    	
    	List<Integer> result = new ArrayList<Integer>();
    	
    	for (Integer key : frequents.keySet()) {
    		if (frequents.get(key) == max) {
    			result.add(key);
    		}
    	}
    	
    	int[] ret = new int[result.size()];
    	for (int i = 0; i < result.size(); i++) {
    		ret[i] = result.get(i);
    	}
    	
        return ret;
    }
    
    private int tranverseTree(TreeNode root, Map<Integer, Integer> frequents) {
    	
    	int leftSum = 0;
    	int rightSum = 0;
    	
    	if (root.left != null) {
    		leftSum = tranverseTree(root.left, frequents);
    	}
    	
    	if (root.right != null) {
    		rightSum = tranverseTree(root.right, frequents);
    	}
    	
    	int sum = root.val + leftSum + rightSum;
    	
    	int frequent = frequents.get(sum) == null ? 0 : frequents.get(sum);
    	
    	frequents.put(sum, frequent + 1);
    	
    	return sum;
    }

}
