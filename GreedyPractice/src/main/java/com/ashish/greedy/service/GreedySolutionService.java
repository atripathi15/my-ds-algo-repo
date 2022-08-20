package com.ashish.greedy.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.ashish.greedy.comparator.ActivityComparator;
import com.ashish.greedy.model.Activity;
import com.ashish.greedy.model.Item;

@Service
public class GreedySolutionService {
	
	/**
	 * Given a set of activities, find max no of activities that can run on a single tasking machine
	 * TimeComplexity O(nlogn)
	 */
	public int getMaxActivity(Activity[] activities) {
		int result = 0;
		Arrays.sort(activities, new ActivityComparator());
		result = 1;
		int prev = 0;
		for(int i = 1; i< activities.length; i++) {
			if(activities[i].getStart()>= activities[prev].getFinish()) {
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
		
		for(int i = 1; i< items.length; i++) {
			if(items[i].getWeight() <= totalWeight) {
				result += items[i].getValue();
				totalWeight = totalWeight - items[i].getWeight();
			} else {
				result += totalWeight*items[i].getValue()/items[i].getWeight();
				break;
			}
		}		
		return result;		
	}

}
