package com.ds.tree.service;

import org.springframework.stereotype.Service;

import com.ds.tree.model.BTNode;

@Service
public class TreeUtilService {
	
	/**
	 * Total no of nodes in the tree
	 * Runtime Complexity O(n) : Space Complexity O(h)
	 * Queue based Level order traversal method is also available with better space complexity of O(w). Recommended for skewed trees
	*/
	public int getSize(BTNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + getSize(root.getLeft()) + getSize(root.getRight());
		}
	}
	
	/**
	 * Find maximum key of all the nodes of the tree
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	 * Queue based Level order traversal method is also available with better space complexity of O(w). Recommended for skewed trees
	*/
	public int getMaximum(BTNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(root.getKey(), Math.max(getMaximum(root.getLeft()), getMaximum(root.getRight())));
		}
	}
	
	/**
	 * Child sum property hold true when every parent node is sum of left and right child
	 * Runtime Complexity O(n) : Space Complexity O(h)
	*/
	public boolean isChildSum(BTNode root) {
		if (root == null) {
			return true;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return true;
		}
		
		int sum = 0;
		if (root.getLeft() != null) {
			sum += root.getLeft().getKey();
		}
		if (root.getRight() != null) {
			sum += root.getRight().getKey();
		}		
		return ((sum==root.getKey()) && isChildSum(root.getLeft()) && isChildSum(root.getRight()));
	}
	

}
