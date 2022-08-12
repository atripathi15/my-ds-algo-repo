package com.ashish.heap;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
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
		return (int) Math.floor((double)(i-1)/2);
	}
	
	/**
	 *  Time Complexity : O(logn) , Space Complexity : O(1)
	*/
	public void insert(int x) {
		if (size == capacity)
			return;
		size++;
		arr[size - 1] = x;
		for (int i = size - 1; i > 0 && arr[parent(i)] > arr[i];) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	/**
	 *  Time Complexity : O(logn) , Space Complexity : O(logn)
	*/
	public void minHeapify(int index) {
		int left = left(index);
		int right = right(index);
		int smallest = index;
		if (left < size && arr[smallest] > arr[left]) {
			smallest = left;
		}
		if (right < size && arr[smallest] > arr[right]) {
			smallest = right;
		}
		if (smallest != index) {
			swap(index, smallest);
			minHeapify(smallest);
		}
	}
	
	private void swap(int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

	/**
	 *  Time Complexity : O(logn) , Space Complexity : O(logn)
	*/
	public int extractMin() {
		if(size == 0) {
			return Integer.MIN_VALUE;
		}
		if(size == 1) {
			size--;
			return arr[0];
		}
		swap(0, size-1);
		size--;
		minHeapify(0);
		return arr[size];
	}
	
	/**
	 *  Time Complexity : O(logn) , Space Complexity : O(1)
	*/
	public void decreaseKey(int index, int x) {
		if (index < size) {
			arr[index] = x;
			while (index != 0 && arr[parent(index)] > arr[index]) {
				swap(index, parent(index));
				index = parent(index);
			}
		}
	}
	
	/**
	 *  Time Complexity : O(logn)
	*/
	public void delete(int i) {
		if (i < size) {
			decreaseKey(i, Integer.MIN_VALUE);
			extractMin();		
		}

	}
	
	/**
	 * Given a random array, rearrange its elements to form a min heap
	 * Time Complexity : O(nlogn)
	 */
	public void buildMinHeap(int[] a) {
		int size = a.length;
		for(int i = size-2/2;i>=0;i--) {
			minHeapify(i);
		}
	}	

}
