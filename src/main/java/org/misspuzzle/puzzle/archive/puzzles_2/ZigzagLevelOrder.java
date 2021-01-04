package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.misspuzzle.datastructure.TreeNode;


public class ZigzagLevelOrder implements Puzzle {

	@Override
	public void execute() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(zigzagLevelOrder(root));

	}
	
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
