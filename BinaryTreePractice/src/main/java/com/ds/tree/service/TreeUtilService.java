package com.ds.tree.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.tree.model.BTNode;

@Service
public class TreeUtilService {
	
	@Autowired
	private TreeHeightSevice treeHeightService;
	
	private int preIndex = 0;	
	
	private Integer EMPTY = -1;
	
	private int index = 0;
	
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
	
	/**
	 * Runtime Complexity O(n2)
	*/
	public boolean isBalancedNaive(BTNode root) {
		if (root == null)return true;
		int lHeight = treeHeightService.getBTHeight(root.getLeft());
		int rHeight = treeHeightService.getBTHeight(root.getRight());
		return (Math.abs(lHeight - rHeight) <= 1 && isBalancedNaive(root.getLeft()) && isBalancedNaive(root.getRight()));
	}
	
	/**
	 * return -1 if not balanced else return height
	 * Runtime Complexity O(n)
	*/
	public int isBalanced(BTNode root) {
		if (root == null)
			return 0;
		int lHeight = isBalanced(root.getLeft());
		if (lHeight == -1)
			return -1;
		int rHeight = isBalanced(root.getRight());
		if (rHeight == -1)
			return -1;
		if (Math.abs(lHeight - rHeight) > 1)
			return -1;
		else
			return 1 + Math.max(lHeight, rHeight);
	}
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(n) or more precisely theta(w) 
	 * because  w = n/2 in a perfect binary tree
	*/
	public int getMaxWidth(BTNode root) {
		if (root == null) return 0;
		LinkedList<BTNode> queue = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			max = Math.max(max, count);
			for (int i = 0; i < count; i++) {
				BTNode current = queue.poll();				
				if (current.getLeft() != null)
					queue.add(current.getLeft());
				if (current.getRight() != null)
					queue.add(current.getRight());
			}
		}
		return max;
	
	}
	
	/**
	 * Runtime Complexity O(n2).
	 * Can be improved by using a hahtable to store elements of inorder as key and its correspoding index as value
	 * start and end are starting and end index of inorder array
	*/
	public BTNode constructTree(int[] preOrderArr, int[] inOrderArr, int start, int end) {
		if(start > end) return null;
		BTNode root = new BTNode(preOrderArr[preIndex++]);
		int index = 0;
		for (int i = start; i<=end;i++) {
			if(inOrderArr[i] == root.getKey()) {
				index = i;
				break;
			}
		}
		root.setLeft(constructTree(preOrderArr, inOrderArr, start, index-1));
		root.setRight(constructTree(preOrderArr, inOrderArr, index+1, end));
		return root;		
	}
	
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(h)
	 * return preorder traversal of tree with -1 for null leaf nodes
	*/
	public void serializeTree(BTNode root, List<Integer> serializedTreeList){
		if(root == null) {
			serializedTreeList.add(EMPTY);
			return;
		}
		serializedTreeList.add(root.getKey());
		serializeTree(root.getLeft(), serializedTreeList);
		serializeTree(root.getRight(), serializedTreeList);
	}
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(h)
	*/
	public BTNode deSerializeTree(List<Integer> serializedTreeList) {
		if (index == serializedTreeList.size())
			return null;		
		int key = serializedTreeList.get(index);
		index++;
		if(key == EMPTY) {
			return null;
		}
		BTNode root = new BTNode(key);
		root.setLeft(deSerializeTree(serializedTreeList));
		root.setRight(deSerializeTree(serializedTreeList));
		return root;
	}
	
	/**
	 * count no of nodes in a complete binary tree. getSize() can be used
	 * but its complexity is O(n)
	 * Runtime Complexity O(logn * logn) 
	*/
	public int countNode(BTNode root) {
		if (root == null)return 0;
		int lh = 0;
		int rh = 0;
		BTNode current = root;
		while (current != null) {
			lh++;
			current = current.getLeft();			
		}
		current = root;
		while (current != null) {
			rh++;
			current = current.getRight();			
		}
		if (lh == rh)
			return (int) (Math.pow(2, lh) - 1);
		return 1 + countNode(root.getLeft()) + countNode(root.getRight());
	}
	

}
