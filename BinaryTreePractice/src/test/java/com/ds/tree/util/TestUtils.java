package com.ds.tree.util;

import com.ds.tree.model.BTNode;

public class TestUtils {
	
	public BTNode createEmptyTree() {		
		return null;
	}
	
	public BTNode createOneNodeTree() {		
		return new BTNode(10);
	}

	public BTNode createBinaryTree1() {
		BTNode root = new BTNode(10);
		BTNode left1 = new BTNode(20);
		BTNode right1 = new BTNode(30);
		BTNode left2 = new BTNode(40);
		BTNode right2 = new BTNode(50);
		right1.setLeft(left2);
		right1.setRight(right2);
		root.setLeft(left1);
		root.setRight(right1);
		return root;
	}

	public BTNode createBinaryTree2() {
		BTNode root = new BTNode(10);
		BTNode left1 = new BTNode(20);
		BTNode right1 = new BTNode(30);
		BTNode left2 = new BTNode(40);
		BTNode right2 = new BTNode(50);
		BTNode right21 = new BTNode(60);
		BTNode left3 = new BTNode(70);
		BTNode right3 = new BTNode(80);
		right2.setLeft(left3);
		right2.setRight(right3);
		left1.setLeft(left2);
		left1.setRight(right2);
		right1.setRight(right21);
		root.setLeft(left1);
		root.setRight(right1);
		return root;
	}
	
	public BTNode createChildSumTree() {
		BTNode root = new BTNode(10);
		BTNode left1 = new BTNode(2);
		BTNode right1 = new BTNode(8);
		BTNode left2 = new BTNode(6);
		BTNode right2 = new BTNode(2);
		right1.setLeft(left2);
		right1.setRight(right2);
		root.setLeft(left1);
		root.setRight(right1);
		return root;
	}

}
