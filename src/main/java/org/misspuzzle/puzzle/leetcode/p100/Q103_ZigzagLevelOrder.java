package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Q103_ZigzagLevelOrder {
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	if (root == null) {
    		return result;
    	}
    	
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> nextStack = new Stack<TreeNode>();
        
        boolean leftToRight = true;
        
        stack.push(root);
        
    	while (stack.size() > 0) {
    		List<Integer> list = new ArrayList<Integer>();
    		
    		while (stack.size() > 0) {
    			TreeNode node = stack.pop();
    			
    			list.add(node.val);
    			
    			TreeNode nextNode = leftToRight ? node.left : node.right;
    			if (nextNode != null) {
    				nextStack.push(nextNode);
    			}
    			
    			nextNode = leftToRight ? node.right : node.left;
    			if (nextNode != null) {
    				nextStack.push(nextNode);
    			}
    		}
    		
    		result.add(list);
    		
    		stack = nextStack;
    		nextStack = new Stack<TreeNode>();
    		
    		leftToRight = !leftToRight;
    		
    	}
    	
    	return result;
    }

}
