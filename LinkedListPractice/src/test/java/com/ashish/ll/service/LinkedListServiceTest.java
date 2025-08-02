package com.ashish.ll.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ashish.ll.model.Node;

public class LinkedListServiceTest {

	@Test
	public void testReverseLinkedList_MultipleNodes() {
		// 1 -> 2 -> 3 -> null
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);

		LinkedListService service = new LinkedListService();
		Node reversed = service.reverseLinkedList(head);

		// Expect: 3 -> 2 -> 1 -> null
		assertEquals(3, reversed.data);
		assertEquals(2, reversed.next.data);
		assertEquals(1, reversed.next.next.data);
		assertNull(reversed.next.next.next);
	}

}
