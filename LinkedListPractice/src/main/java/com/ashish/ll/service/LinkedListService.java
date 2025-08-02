package com.ashish.ll.service;

import com.ashish.ll.model.Node;

public class LinkedListService {

	public Node reverseLinkedList(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

}
