package com.ashish.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PriorityQueueTest {
	
	@Test
	public void priorityQueueTest() {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.add(40);
		minHeap.add(35);
		minHeap.add(30);
		minHeap.add(38);
		minHeap.add(12);
		assertEquals(12, minHeap.peek());
		assertEquals(12, minHeap.poll());
		assertEquals(30, minHeap.peek());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		maxHeap.add(40);
		maxHeap.add(35);
		maxHeap.add(30);
		maxHeap.add(38);
		maxHeap.add(12);
		assertEquals(40, maxHeap.peek());
		assertEquals(40, maxHeap.poll());
		assertEquals(38, maxHeap.peek());
	}

}
