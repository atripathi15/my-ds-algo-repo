package com.ashish.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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
	
	/**
	 * Method to sort k sorted array
	 * Time Complexity : O(klogk)+O((n-k)logk)+O(klogk) = O(nlogk)
	 */
	public void sortKSortedArray(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int index = 0;
		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k + 1; i < arr.length; i++) {
			arr[index++] = pq.poll();
			pq.add(arr[i]);
		}
		while (!pq.isEmpty()) {
			arr[index++] = pq.poll();
		}
	}
	
	/**
	 * Find k largest elements in a given array. They need not be in sorted order
	 * Time Complexity : O(n)+O((klogn) = O((n+k)logn)
	 */
	public int[] findKLargestUsingMaxHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] result = new int[k];
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		for (int i = 0; i < k; i++) {
			result[i] = pq.poll();
		}
		return result;
	}
	
	/**
	 * Faster Method
	 * Find k largest elements in a given array. They need not be in sorted order
	 * Time Complexity : O(k)+O((n-k)logk)+O(klogk) = O((n+k)logk)
	 */
	public int[] findKLargestUsingMinHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			if (arr[i] > pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		int index = 0;
		while (!pq.isEmpty()) {
			result[index++] = pq.poll();
		}
		return result;
	}
	
	/**
	 * Find k closest elements to a given element x in a given array. They need not be in sorted order
	 * Time Complexity : O(k)+O((n-k)logk)+O(klogk) = O((n+k)logk)
	 */
	public int[] findKClosest(int[] arr, int x, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			pq.add(new Pair(x-arr[i],i));
		}
		for (int i = k; i < arr.length; i++) {
			int diff = x - arr[i];
			if (diff < pq.peek().difference) {
				pq.poll();
				pq.add(new Pair(diff,i));
			}
		}
		int index = 0;
		while (!pq.isEmpty()) {
			result[index++] = arr[pq.poll().index];
		}
		return result;
	}
	
	class Pair implements Comparable<Pair>{
		int difference;
		int index;
		
		Pair(int difference, int index){
			this.difference = difference;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			return difference - o.difference;
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
	
	class Triplet implements Comparable<Triplet>{
		int value;
		int arrayPos;
		int valuePos;
		
		Triplet(int value, int arrayPos, int valuePos) {
			this.value = value;
			this.arrayPos = arrayPos;
			this.valuePos = valuePos;
		}

		@Override
		public int compareTo(Triplet o) {
			if(value <= o.value) return -1;
			else return 1;
		}		
	}
	
	/**
	 * Given k sorted arrays, merge them into a single sorted array
	 * Time Complexity : O(nklogk)
	 */
	public List<Integer> mergeKSortedArrays(List<List<Integer>> arr) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Triplet> pq = new PriorityQueue<>();
		int arrIndex = 0;
		for (List<Integer> i : arr) {
			pq.add(new Triplet(i.get(0), arrIndex, 0));
			arrIndex++;
		}
		while (!pq.isEmpty()) {
			Triplet curr = pq.poll();
			int arrayPos = curr.arrayPos;
			int valuePos = curr.valuePos;
			result.add(curr.value);
			if (valuePos + 1 < arr.get(arrayPos).size()) {
				pq.add(new Triplet(arr.get(arrayPos).get(valuePos + 1), arrayPos, valuePos + 1));
			}
		}
		return result;
	}
	
	/**
	 * Find median of a given array (middle element of sorted array if the array is odd, avg sum of middle two elements when array size is even)
	 * Input : {2,22,14,15,20}
	 * Output: {2,12,14,14.5,15}
	 * Time Complexity : O(nlogn)
	 */
	public List<Double> getArrayMedian(int[] arr) {
		List<Double> medianList = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		maxHeap.add(arr[0]);
		medianList.add((double) arr[0]);
		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];
			if (maxHeap.size() > minHeap.size()) {
				if (maxHeap.peek() > x) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(x);
				} else {
					minHeap.add(x);					
				}
				medianList.add((double)(minHeap.peek() + maxHeap.peek()) / 2);

			} else {
				if (maxHeap.peek() >= x) {					
					maxHeap.add(x);
				} else {
					minHeap.add(x);
					maxHeap.add(minHeap.poll());
				}
				medianList.add((double) maxHeap.peek());

			}
		}
		return medianList;
	}

}
