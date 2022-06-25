package com.ds.tree.service;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.ds.tree.model.BTNode;

@Service
public class TreeTraversalSevice {
	
	private StringBuilder traversalString = new StringBuilder();
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	*/
	public String inOrderTraversal(BTNode root) {
		if (root != null) {
			inOrderTraversal(root.getLeft());
			traversalString.append(root.getKey()).append(" ");
			inOrderTraversal(root.getRight());
		}
		return traversalString.toString();
	}
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	*/
    public String preOrderTraversal(BTNode root) {
		if (root != null) {
			traversalString.append(root.getKey()).append(" ");
			preOrderTraversal(root.getLeft());			
			preOrderTraversal(root.getRight());
		}
		return traversalString.toString();
	}
    
    /**
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	*/
    public String postOrderTraversal(BTNode root) {

		if (root != null) {
			postOrderTraversal(root.getLeft());			
			postOrderTraversal(root.getRight());
			traversalString.append(root.getKey()).append(" ");
		}
		return traversalString.toString();
	}
    
    /**
	 * Runtime Complexity O(n) : Space Complexity O(n) or more precisely theta(w) 
	 * where w is width of tree
	*/
	public String levelOrderTraversal(BTNode root) {
		LinkedList<BTNode> queue = new LinkedList<>();
		if (root == null) {
			return "";
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			BTNode current = queue.poll();
			traversalString.append(current.getKey()).append(" ");
			if (current.getLeft() != null)
				queue.add(current.getLeft());
			if (current.getRight() != null)
				queue.add(current.getRight());
		}
		return traversalString.toString();
	}
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(n) or more precisely theta(w) 
	 * where w is width of tree
	*/
	public String levelOrderTraversalLineByLine(BTNode root) {
		LinkedList<BTNode> queue = new LinkedList<>();
		if (root == null) {
			return "";
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				BTNode current = queue.poll();
				traversalString.append(current.getKey()).append(" ");
				if (current.getLeft() != null)
					queue.add(current.getLeft());
				if (current.getRight() != null)
					queue.add(current.getRight());
			}
			traversalString.append("\n");
		}
		return traversalString.toString();
	}
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	*/
	public String printDist(BTNode root, int k) {

		if (root == null)
			return "";
		if (k == 0)
			return traversalString.append(root.getKey()).append(" ").toString();
		else {
			printDist(root.getLeft(), k - 1);
			printDist(root.getRight(), k - 1);
		}
		return traversalString.toString();
	}
    
    public void resetTraverstalString() {
    	traversalString = new StringBuilder();
    }

}
