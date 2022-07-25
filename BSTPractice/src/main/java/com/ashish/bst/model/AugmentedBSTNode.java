package com.ashish.bst.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AugmentedBSTNode {

	private int key;
	private AugmentedBSTNode left;
	private AugmentedBSTNode right;
	private int lCount;

	public AugmentedBSTNode(int key, int lCount) {
		this.key = key;
		this.lCount = lCount;
	}
}
