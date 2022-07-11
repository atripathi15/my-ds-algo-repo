package com.ashish.bst.service;

import org.springframework.stereotype.Service;

import com.ashish.bst.model.BSTNode;

@Service
public class BSTOperationService {

	/**
	 * Runtime Complexity O(h) : Space Complexity O(h)
	 */
	public boolean searchBSTRecursive(BSTNode root, int key) {
		if (root == null)
			return false;
		if (root.getKey() == key)
			return true;
		else if (key < root.getKey())
			return searchBSTRecursive(root.getLeft(), key);
		else
			return searchBSTRecursive(root.getRight(), key);
	}

	/**
	 * Space complexity is less hence more efficient Runtime Complexity O(h) : Space
	 * Complexity O(1)
	 */
	public boolean searchBSTIterative(BSTNode root, int key) {
		if (root == null)
			return false;
		while (root != null) {
			if (root.getKey() == key)
				return true;
			else if (key < root.getKey())
				root = root.getLeft();
			else
				root = root.getRight();
		}
		return false;
	}

	/**
	 * Runtime Complexity O(h) : Space Complexity O(h)
	 */
	public BSTNode insertRecursive(BSTNode root, int key) {
		if (root == null) {
			return new BSTNode(key);
		}
		if (key < root.getKey())
			root.setLeft(insertRecursive(root.getLeft(), key));
		else if (key > root.getKey())
			root.setRight(insertRecursive(root.getRight(), key));
		return root;
	}

	/**
	 * Runtime Complexity O(h) : Space Complexity O(1)
	 */
	public BSTNode insertIterative(BSTNode root, int key) {
		BSTNode temp = new BSTNode(key);
		BSTNode parent = null;
		BSTNode current = root;
		while (current != null) {
			parent = current;
			if (key < current.getKey()) {
				current = current.getLeft();
			} else if (key > current.getKey()) {
				current = current.getRight();
			} else
				return root;
		}
		if (parent == null)
			return temp;
		else if (key < parent.getKey())
			parent.setLeft(temp);
		else
			parent.setRight(temp);
		return root;

	}
	

	/**
	 * Runtime Complexity O(h) : Space Complexity O(1)
	 */
	public BSTNode delete(BSTNode root, int key) {
		// step 1 : search node with given key
		if (root == null)
			return null;
		if (key < root.getKey()) {
			root.setLeft(delete(root.getLeft(), key));
		} else if (key > root.getKey()) {
			root.setRight(delete(root.getRight(), key));
		} else {
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();
			else {
				BSTNode succ = getSuccessor(root);
				root.setKey(succ.getKey());
				root.setRight(delete(root.getRight(), key));
			}
		}
		return root;

	}
	
	private BSTNode getSuccessor(BSTNode root) {
		BSTNode curr = root.getRight();
		while (curr != null && curr.getLeft() != null) {
			curr = curr.getLeft();
		}
		return curr;

	}
	
	/**
	 * Returns node equal to or largest node less than the given key
	 * Runtime Complexity O(h) : Space Complexity O(1)
	 */
	public BSTNode getFloor(BSTNode root, int key) {
		if (root == null)
			return null;
		BSTNode result = null;
		while (root != null) {
			if (root.getKey() == key)
				return root;
			else if (root.getKey() > key) {
				root = root.getLeft();
			} else {
				result = root;
				root = root.getRight();
			}
		}
		return result;
	}
	
	/**
	 * Returns node equal to or smallest node greater than the given key
	 * Runtime Complexity O(h) : Space Complexity O(1)
	 */
	public BSTNode getCeil(BSTNode root, int key) {
		if (root == null)
			return null;
		BSTNode result = null;
		while (root != null) {
			if (root.getKey() == key)
				return root;
			else if (root.getKey() > key) {
				result = root;
				root = root.getLeft();
			} else {
				root = root.getRight();
			}
		}
		return result;
	}

}
