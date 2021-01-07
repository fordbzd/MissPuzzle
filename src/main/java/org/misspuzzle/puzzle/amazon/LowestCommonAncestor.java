package org.misspuzzle.puzzle.amazon;

import org.misspuzzle.datastructure.TreeNode;

public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		
		Result r = new Result();
		
    	TreeNode left = root.left == null ? null : findAncestor(root.left, p, q, r);
    	if (r.isFound) {
    		return left;
    	}
    	
    	TreeNode right = root.right == null ? null : findAncestor(root.right, p, q, r);
    	if (r.isFound) {
    		return right;
    	}
    	
    	if ((left != null && right != null) || 
			((root.val == p.val || root.val == q.val) && (left != null || right != null))) {
    		return root;
    	}
    	
    	return null;
		
	}
	
    private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q, Result r) {
    	TreeNode left = root.left == null ? null : findAncestor(root.left, p, q, r);
    	if (r.isFound) {
    		return left;
    	}
    	
    	TreeNode right = root.right == null ? null : findAncestor(root.right, p, q, r);
    	if (r.isFound) {
    		return right;
    	}
    	
    	if ((left != null && right != null) || 
    			((root.val == p.val || root.val == q.val) && (left != null || right != null))) {
    		r.isFound = true;
    		return root;
    	}
    	
        if (root.val == p.val || root.val == q.val) {
        	return root;
        }
    	
    	return left != null ? left : right;
    	
    }
    
    class Result {
    	boolean isFound = false;
    }

}
