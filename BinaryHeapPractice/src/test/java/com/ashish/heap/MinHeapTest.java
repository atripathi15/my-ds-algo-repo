package com.ashish.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class MinHeapTest {

	TestUtils testUtils;	

	@InjectMocks
	private MinHeap minHeap;

	@BeforeAll
	public void setUp() {
		minHeap = new MinHeap(10);
		testUtils = new TestUtils();		
	}

	@BeforeEach
	public void init() {
		System.out.println("in init method");

	}

	@AfterEach
	public void teardown() {
		System.out.println("in teardown method");
	}

	@Test
	public void minHeapInsertTest() {
		minHeap.insert(14);
		minHeap.insert(12);
		minHeap.insert(10);
		minHeap.insert(18);
		minHeap.insert(22);
		minHeap.insert(17);
		minHeap.insert(3);
		minHeap.insert(5);
		minHeap.insert(11);
		minHeap.insert(6);
		System.out.println(" Min Heap is: ");
		Arrays.stream(minHeap.getArr()).forEach(v->System.out.print(" "+v));
		
		int min = minHeap.extractMin();
		assertEquals(min, 3);
		
		min = minHeap.extractMin();
		assertEquals(min, 5);
		
		minHeap.delete(5);
		//minHeap.delete(3);
		System.out.println(" Min Heap is: ");
		int count =0;
		while(count < minHeap.getSize()) {
			System.out.print(" "+minHeap.getArr()[count]);
			count++;
		}
		//assertEquals(minHeap.getSize(), 8);
		
	}

	
}
