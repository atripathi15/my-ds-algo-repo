package com.ds.tree.service;

import org.springframework.stereotype.Service;

import com.ds.tree.model.BTNode;
import com.ds.tree.model.Distance;

@Service
public class TreeHeightSevice {
	
	private int result = 0;
	private int burnTime = 0;	
	
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
	
	/**
	 * No of nodes of the longest path between 2 leaf nodes
	 * Runtime Complexity O(n2) 
	*/
	public int getBTDiameterNaive(BTNode root) {
		if (root == null) {
			return 0;
		}
		int d1 = 1 + getBTHeight(root.getLeft())+getBTHeight(root.getRight());
		int d2 = getBTDiameterNaive(root.getLeft());
		int d3 = getBTDiameterNaive(root.getRight());
		return Math.max(d1, Math.max(d2, d3));
	}
	
	/**
	 * No of nodes of the longest path between 2 leaf nodes
	 * Uses logic of height function
	 * Runtime Complexity O(n) : Space Complexity O(h) 
	*/
	public int getHeightForDiameter(BTNode root) {
		if (root == null) {
			return 0;
		}
		int lh = getHeightForDiameter(root.getLeft());
		int rh = getHeightForDiameter(root.getRight());
		result = Math.max(result, 1 + lh + rh);
		return 1 + Math.max(lh, rh);
	}
	
	/**
	 * This function returns height of the tree. Also it sets the value of burnTime if leaf is descendant
	 * @param root
	 * @param leaf
	 * @param dist
	 * @return
	 */
	
	public int burnTime(BTNode root, int leaf, Distance dist) {
		if(root == null) return 0;
		if(root.getKey()==leaf) {
			dist.setValue(0);
			return 1;
		}
		Distance ldist = new Distance(-1);
		Distance rdist = new Distance(-1);
		int lh = burnTime(root.getLeft(), leaf, ldist);
		int rh = burnTime(root.getRight(), leaf, rdist);
		if(ldist.getValue() != -1) {
			dist.setValue(ldist.getValue() +1);
			burnTime = Math.max(burnTime, rh + dist.getValue());
		}
		if(rdist.getValue() != -1) {
			dist.setValue(rdist.getValue() +1);
			burnTime = Math.max(burnTime, lh + dist.getValue());
		}
		return 1+Math.max(lh, rh);		
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getBurnTime() {
		return burnTime;
	}

	public void setBurnTime(int burnTime) {
		this.burnTime = burnTime;
	}	
	

}
