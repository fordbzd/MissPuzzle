package puzzles_amazon;

import interfaces.Puzzle;
import datastructure.TreeNode;

public class LowestCommonAncestor implements Puzzle {

	@Override
	public void execute() {
		//    6
		//  /   \
		//  2    8
		// / \  / \
		// 0 4  7 9
		//  / \    \
		//  3 5    1
		
		TreeNode root = new TreeNode(6);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		root.right.right.right = new TreeNode(1);
		
		// Test
		TreeNode result = lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5));
		System.out.println(result != null ? result.val : "Null");
	}
	
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
