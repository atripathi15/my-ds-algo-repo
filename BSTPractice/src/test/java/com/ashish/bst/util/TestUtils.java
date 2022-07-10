package com.ashish.bst.util;

import com.ashish.bst.model.BSTNode;

public class TestUtils {
	
	public BSTNode createEmptyTree() {		
		return null;
	}
	
	public BSTNode createOneNodeTree() {		
		return new BSTNode(10);
	}

	public BSTNode createBSTree1() {
		BSTNode root = new BSTNode(30);
		BSTNode left1 = new BSTNode(20);
		BSTNode right1 = new BSTNode(40);
		BSTNode left2 = new BSTNode(10);
		BSTNode right2 = new BSTNode(25);
		BSTNode left3 = new BSTNode(35);
		BSTNode right3 = new BSTNode(50);
		BSTNode right4 = new BSTNode(38);
		left1.setLeft(left2);
		left1.setRight(right2);
		right1.setLeft(left3);
		right1.setRight(right3);
		left3.setRight(right4);
		root.setLeft(left1);
		root.setRight(right1);
		return root;
	}

	public BSTNode createBSTree2() {
		BSTNode root = new BSTNode(30);
		BSTNode left1 = new BSTNode(20);
		BSTNode right1 = new BSTNode(40);
		BSTNode left2 = new BSTNode(10);
		BSTNode right2 = new BSTNode(25);
		BSTNode left3 = new BSTNode(35);
		BSTNode right3 = new BSTNode(50);
		BSTNode right4 = new BSTNode(38);
		left1.setLeft(left2);
		left1.setRight(right2);
		right1.setLeft(left3);
		right1.setRight(right3);
		left3.setRight(right4);
		root.setLeft(left1);
		root.setRight(right1);
		return root;
	
	}

}
