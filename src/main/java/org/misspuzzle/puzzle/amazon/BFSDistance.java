package org.misspuzzle.puzzle.amazon;

import org.misspuzzle.puzzle.Puzzle;

import java.util.ArrayList;

import org.misspuzzle.datastructure.TreeNode;

public class BFSDistance implements Puzzle {

	@Override
	public void execute() {
		int[] test = {7, 4, 1, 8, 10, 6, 9, 5};
		
		System.out.println(bstDistance(test, 8, 1, 19));

	}
	
	public int bstDistance(int[] values, int n, int node1, int node2) {

		if (n <= 0) {
			return -1;
		}
		
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
		
		TreeNode root = new TreeNode(values[0]);
		
		for (int i = 1; i < n; i++) {
			int value = values[i];
			
			TreeNode p = root;
			ArrayList<TreeNode> path = null;
			boolean isTarget = false;
			
			if (value == node1) {
				path = path1;
				isTarget = true;
			} else if (value == node2) {
				path = path2;
				isTarget = true;
			}
			
			while(p != null) {
				if (isTarget) {
					path.add(p);
				}
				
				if (p.val >= value) {
					if (p.left == null) {
						p.left = new TreeNode(value);
						if (isTarget) {
							path.add(p.left);
						}
						break;
					} else {
						p = p.left;
					}
				} else if (p.val < value) {
					if (p.right == null) {
						p.right = new TreeNode(value);
						if (isTarget) {
							path.add(p.right);
						}
						break;
					} else {
						p = p.right;
					}
				}
			}
		}
		
		// Compare Path
		if (path1.size() == 0 || path2.size() == 0) {
			return -1;
		}
		
		int i;
		for (i = 0; i < (path1.size() > path2.size() ? path2.size() : path1.size()); i++) {
			if (path1.get(i) != path2.get(i)) {
				i--;
				break;
			}
		}
		
		// Since index starts from 0, make up 1 more step here.
		i++;
		
		return (path1.size() - i) + (path2.size() - i);
		
	}

}