package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayDeque;
import java.util.Deque;

import org.misspuzzle.datastructure.TreeNode;

public class FindBottomLeftValue implements Puzzle {

	@Override
	public void execute() {
		TreeNode root = new TreeNode(4);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.right.right = new TreeNode(6);
		
		System.out.println(findBottomLeftValue(root));

	}
	
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
