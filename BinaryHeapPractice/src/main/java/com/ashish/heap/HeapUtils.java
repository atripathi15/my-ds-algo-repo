package com.ashish.heap;

import org.springframework.stereotype.Component;

@Component
public class HeapUtils {

	/**
	 * Time Complexity : O(nlogn)
	 */
	public void heapSort(int[] arr) {
		buildMaxHeap(arr);
		int n = arr.length;
		for (int i = n - 1; i > 0; i--) {
			swap(arr, 0, i);
			maxHeapify(arr, i, 0);
		}
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
	 *  Time Complexity : O(logn) , Space Complexity : O(logn)
	*/
	public void maxHeapify(int[] arr, int size, int index) {
		int left = left(index);
		int right = right(index);
		int largest = index;
		if (left < size && arr[largest] < arr[left]) {
			largest = left;
		}
		if (right < size && arr[largest] < arr[right]) {
			largest = right;
		}
		if (largest != index) {
			swap(arr, index, largest);
			maxHeapify(arr, size, largest);
		}
	}
	
	/**
	 * Given a random array, rearrange its elements to form a min heap
	 * Time Complexity : O(nlogn)
	 */
	public void buildMaxHeap(int[] arr) {
		int size = arr.length;
		for(int i = size-2/2;i>=0;i--) {
			maxHeapify(arr,size,i);
		}
	}
	
	public void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

}
