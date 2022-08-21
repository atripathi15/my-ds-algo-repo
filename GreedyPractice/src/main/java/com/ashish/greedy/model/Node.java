package com.ashish.greedy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
	char ch;
	int freq;
	Node left;
	Node right;

	public Node(char ch, int freq, Node left, Node right) {
		this.ch = ch;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}

}
