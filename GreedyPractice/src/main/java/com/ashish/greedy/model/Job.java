package com.ashish.greedy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Job {

	char id;
	int deadline;
	int profit;

	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}
