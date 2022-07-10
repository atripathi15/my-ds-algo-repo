package com.ashish.bst.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BSTNode {
	private int key;
	private BSTNode left;
	private BSTNode right;

	public BSTNode(int key) {
		this.key = key;
	}
}
