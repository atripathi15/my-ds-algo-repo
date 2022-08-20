package com.ashish.greedy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item implements Comparable<Item>{
	int weight;
	int value;	
	
	public Item(int weight, int value) {
		this.value = value;
		this.weight = weight;
	}

	@Override
	public int compareTo(Item o) {
		return o.getValue()/o.getWeight() - this.value/this.weight;
	}
}
