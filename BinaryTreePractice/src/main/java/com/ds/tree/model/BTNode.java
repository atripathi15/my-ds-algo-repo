package com.ds.tree.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BTNode {
	private int key;
	private BTNode left;
	private BTNode right;

	public BTNode(int key) {
		this.key = key;
	}
}
