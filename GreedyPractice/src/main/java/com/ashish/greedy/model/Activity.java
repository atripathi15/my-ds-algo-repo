package com.ashish.greedy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {
	
	int start;
	int finish;
	
	public Activity(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}
}
