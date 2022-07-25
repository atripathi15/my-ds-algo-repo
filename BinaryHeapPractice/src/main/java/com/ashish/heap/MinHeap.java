package com.ashish.heap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinHeap {
	
	private int[] arr;
	private int capacity;
	private int size;
	
	public MinHeap(int c) {
		arr = new int[c];
		size = 0;
		capacity = c;
	}
	
	public int left(int i) {
		return 2*i+1;
	}
	
	public int right(int i) {
		return 2*i+2;
	}
	
	public int parent(int i) {
		return (int) Math.floor((double)i-1/2);
	}
	
	public void insert(int x){
		
	}
	
	public void minHeapify(int index) {
		
	}
	
	public int extractMin() {
		return 1;
	}
	
	public void decreaseKey(int index, int x) {
		
	}
	
	public void delete(int i) {
		
	}
	
	public void buildHeap() {
		
	}	

}
