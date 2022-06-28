package com.ds.tree.service;

import java.util.LinkedList;
import java.util.Stack;

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
	
	/**
	 * Find left nodes at each level
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	*/
	public String printLeftViewIterative(BTNode root) {
		if (root == null)
			return "";
		LinkedList<BTNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				BTNode current = queue.poll();
				if (i == 0) {
					traversalString.append(current.getKey()).append(" ");
				}
				if (current.getLeft() != null)
					queue.add(current.getLeft());
				if (current.getRight() != null)
					queue.add(current.getRight());
			}
		}
		return traversalString.toString();
	}
	
	/**
	 * Runtime Complexity O(n) 
	*/
	public String spiralTreeTraversalNaive(BTNode root) {
		if (root == null) return "";
		LinkedList<BTNode> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		boolean reverse = false;
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				BTNode current = queue.poll();
				if(reverse) {
					stack.push(current.getKey());					
				} else {
					traversalString.append(current.getKey()).append(" ");
				}
					if (current.getLeft() != null) queue.add(current.getLeft());
					if (current.getRight() != null) queue.add(current.getRight());
			}
			if (reverse) {
				while (!stack.isEmpty()) {
					traversalString.append(stack.pop()).append(" ");
				}
			}
			reverse = !reverse;
		}
		return traversalString.toString();
	}
	
	/**
	 * Runtime Complexity O(n)
	*/
	public String spiralTreeTraversal(BTNode root) {
		if (root == null) return "";
		Stack<BTNode> stack1 = new Stack<>();
		Stack<BTNode> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {			
			while (!stack1.isEmpty()) {
				BTNode current = stack1.pop();
				traversalString.append(current.getKey()).append(" ");
				if (current.getLeft() != null) stack2.push(current.getLeft());
				if (current.getRight() != null) stack2.push(current.getRight());
			}			
			while (!stack2.isEmpty()) {
				BTNode current = stack2.pop();
				traversalString.append(current.getKey()).append(" ");
				if (current.getRight() != null) stack1.push(current.getRight());
				if (current.getLeft() != null) stack1.push(current.getLeft());
			}			
		}
		return traversalString.toString();
	}
    
    public void resetTraverstalString() {
    	traversalString = new StringBuilder();
    }

}
