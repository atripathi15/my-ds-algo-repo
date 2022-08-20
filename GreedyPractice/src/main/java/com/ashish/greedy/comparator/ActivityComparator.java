package com.ashish.greedy.comparator;

import java.util.Comparator;

import com.ashish.greedy.model.Activity;

public class ActivityComparator implements Comparator<Activity>{

	@Override
	public int compare(Activity o1, Activity o2) {
		return o1.getFinish() - o2.getFinish();
	}

}
