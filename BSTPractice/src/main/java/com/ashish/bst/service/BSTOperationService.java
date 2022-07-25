package com.ashish.bst.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.ashish.bst.model.AugmentedBSTNode;
import com.ashish.bst.model.BSTNode;
import com.ashish.bst.model.Pair;

@Service
public class BSTOperationService {
	
	private int count = 0;

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
	
	/**
	 * Calculates vertical sum of nodes of a BST. Based on inorder traversal
	 * Runtime Complexity O(nloghd) : Space Complexity O(h)
	 * @param root
	 * @param hd - horizontal distance of a node
	 * @param map
	 */
	public void verticalSumR(BSTNode root, int hd, Map<Integer, Integer> map) {
		if (root == null)
			return;
		verticalSumR(root.getLeft(), hd - 1, map);
		if (map.get(hd) != null) {
			int currSum = map.get(hd);
			map.put(hd, currSum + root.getKey());
		} else {
			map.put(hd, root.getKey());
		}
		verticalSumR(root.getRight(), hd + 1, map);
	}
	
	/**
	 * Print vertical traversal of a BST. Based on Level order traversal
	 * Runtime Complexity O(nloghd) : Space Complexity O(w)
	 */
	public void verticalTraversal(BSTNode root, Map<Integer, List<Integer>> map) {
		Queue<Pair> q = new LinkedList<>();
		//Map<Integer, List<Integer>> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			BSTNode curr = p.getNode();
			int hd = p.getHd();
			if (map.get(hd) != null) {
				map.get(hd).add(curr.getKey());
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(curr.getKey());
				map.put(hd, list);
			}
			if (curr.getLeft() != null) {
				q.add(new Pair(curr.getLeft(), hd - 1));
			}
			if (curr.getRight() != null) {
				q.add(new Pair(curr.getRight(), hd + 1));
			}
		}
	}
	
	/**
	 * Print top view of a BST. Based on Level order traversal
	 * Runtime Complexity O(nloghd) : Space Complexity O(w)
	 */
	public void getTopView(BSTNode root, Map<Integer, List<Integer>> map) {
		Queue<Pair> q = new LinkedList<>();
		//Map<Integer, List<Integer>> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			BSTNode curr = p.getNode();
			int hd = p.getHd();
			if (map.get(hd) == null) {				
				List<Integer> list = new ArrayList<>();
				list.add(curr.getKey());
				map.put(hd, list);
			}
			if (curr.getLeft() != null) {
				q.add(new Pair(curr.getLeft(), hd - 1));
			}
			if (curr.getRight() != null) {
				q.add(new Pair(curr.getRight(), hd + 1));
			}
		}
	}
	
	/**
	 * Print top view of a BST. Based on Level order traversal
	 * Runtime Complexity O(nloghd) : Space Complexity O(w)
	 */
	public void getBottomView(BSTNode root, Map<Integer, List<Integer>> map) {
		Queue<Pair> q = new LinkedList<>();
		// Map<Integer, List<Integer>> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			BSTNode curr = p.getNode();
			int hd = p.getHd();
			List<Integer> list = new ArrayList<>();
			list.add(curr.getKey());
			map.put(hd, list);
			if (curr.getLeft() != null) {
				q.add(new Pair(curr.getLeft(), hd - 1));
			}
			if (curr.getRight() != null) {
				q.add(new Pair(curr.getRight(), hd + 1));
			}
		}
	}
	
	/**
	 * Given an array, print left ceil of every element
	 * Time Complexity : O(nlogn) : Space Complexity : O(1)
	 */
	public String printCeilLeft(int[] arr, int n) {
		StringBuilder result = new StringBuilder();
		result.append("-1");
		TreeSet<Integer> set = new TreeSet<>();
		set.add(arr[0]);
		for(int i=1;i<n;i++) {
			if(set.ceiling(arr[i])!=null) {
				result.append(" "+set.ceiling(arr[i]));
			} else {
				result.append(" -1");
			}
			set.add(arr[i]);
		}
		return result.toString();
	}
	
	
	/**
	 * Given an BST, find kth smallest node. Based on inorder traversal
	 * Time Complexity : O(h+k) : Space Complexity : O(h)
	 */
	public int getKthSmallest(BSTNode root, int k) {
		if (root != null) {
			getKthSmallest(root.getLeft(), k);
			count++;
			if (count == k) {
				return root.getKey();
			}

			return getKthSmallest(root.getRight(), k);
		}
		return -1;
	}
	
	/**
	 * Given an augmented BST, find kth smallest node. Based on lCount.
	 * Time Complexity : O(h) : Space Complexity : O(h)
	 */
	public int getKthSmallestAug(AugmentedBSTNode root, int k) {
		if (root.getLCount() + 1 == k)
			return root.getKey();
		if (root.getLCount() > k) {
			getKthSmallestAug(root.getLeft(), k);
		} else if (root.getLCount() < k) {
			getKthSmallestAug(root.getLeft(), root.getLCount() - k + 1);
		}
		return -1;
	}

}
