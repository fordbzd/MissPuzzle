package org.misspuzzle.puzzle.leetcode.p500;

import org.misspuzzle.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q513_FindBottomLeftValue {
	
    public int findBottomLeftValue(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
     
    	Deque<TreeNode> current = new ArrayDeque<TreeNode>();
    	
    	Deque<TreeNode> next = new ArrayDeque<TreeNode>();
    	
    	current.offer(root);
    	
    	int leftmost = root.val;
    	
    	while (!current.isEmpty()) {
    		
    		boolean hasNode = false;
    		
    		while (!current.isEmpty()) {
    			TreeNode node = current.poll();
    			
    			if (node.left != null) {
    				if (!hasNode) {
    					leftmost = node.left.val;
    					hasNode = true;
    				}
    				
    				next.offer(node.left);
    			}
    			
    			if (node.right != null) {
    				if (!hasNode) {
    					leftmost = node.right.val;
    					hasNode = true;
    				}
    				
    				next.offer(node.right);
    			}
    		}
    		
    		current = next;
    		next = new ArrayDeque<TreeNode>();
    	}
    	
    	return leftmost;
    	
    }

}
