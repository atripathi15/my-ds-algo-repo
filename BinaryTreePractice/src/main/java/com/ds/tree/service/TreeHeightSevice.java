package com.ds.tree.service;

import org.springframework.stereotype.Service;

import com.ds.tree.model.BTNode;

@Service
public class TreeHeightSevice {
	
	/**
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	*/
	public int getBTHeight(BTNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(getBTHeight(root.getLeft()), getBTHeight(root.getRight()));
		}
	}

}
