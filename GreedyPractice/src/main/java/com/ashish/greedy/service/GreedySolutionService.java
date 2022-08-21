package com.ashish.greedy.service;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

import com.ashish.greedy.comparator.ActivityComparator;
import com.ashish.greedy.model.Activity;
import com.ashish.greedy.model.Item;
import com.ashish.greedy.model.Job;
import com.ashish.greedy.model.Node;

@Service
public class GreedySolutionService {

	/**
	 * Given a set of activities, find max no of activities that can run on a single
	 * tasking machine TimeComplexity O(nlogn)
	 */
	public int getMaxActivity(Activity[] activities) {
		int result = 0;
		Arrays.sort(activities, new ActivityComparator());
		result = 1;
		int prev = 0;
		for (int i = 1; i < activities.length; i++) {
			if (activities[i].getStart() >= activities[prev].getFinish()) {
				result += 1;
				prev = i;
			}
		}
		return result;
	}

	public double fractionalKnapSack(Item[] items, int totalWeight) {
		double result = 0;
		Arrays.sort(items);
		result = items[0].getValue();
		totalWeight = totalWeight - items[0].getWeight();

		for (int i = 1; i < items.length; i++) {
			if (items[i].getWeight() <= totalWeight) {
				result += items[i].getValue();
				totalWeight = totalWeight - items[i].getWeight();
			} else {
				result += totalWeight * items[i].getValue() / items[i].getWeight();
				break;
			}
		}
		return result;
	}

	/**
	 * Given a set of jobs, find max profit by optimal scheduling of jobs
	 * TimeComplexity O(n2)
	 */
	public int jobSequencing(Job[] jobArray, int t) {
		int totalProfit = 0;
		Arrays.sort(jobArray, (j1, j2) -> j2.getProfit() - j1.getProfit());
		Job[] selectedJobs = new Job[t];
		for (Job job : jobArray) {
			for (int i = Math.min(t - 1, job.getDeadline()); i >= 0; i--) {
				if (selectedJobs[i] == null) {
					selectedJobs[i] = job;
					totalProfit += job.getProfit();
					break;
				}
			}
		}
		return totalProfit;
	}

	/**
	 * TimeComplexity O(nlogn)
	 */
	public void getHuffmanCode(char[] chArr, int[] freqArr) {
		// Step 1 : Construct huffman tree i.e build minheap O(nlogn)
		PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.getFreq() - n2.getFreq());
		for (int i = 0; i < freqArr.length; i++) {
			minHeap.add(new Node(chArr[i], freqArr[i], null, null));			
		}
		while (minHeap.size() > 1) {
			Node left = minHeap.poll();
			Node right = minHeap.poll();
			minHeap.add(new Node('$',left.getFreq()+right.getFreq(),left,right));			
		}
		// Step 2 : Traverse MinHeap in preorder to get print huffcodes O(n)
		printHuffCode(minHeap.peek(),"");
		

	}

	/** use preorder traversal **/
	private void printHuffCode(Node root, String s) {
		if(root.getCh()!='$') {
			System.out.print(root.getCh()+" "+s+" ");
			return;
		}
		printHuffCode(root.getLeft(),s+"0");
		printHuffCode(root.getRight(),s+"1");
	}

}
