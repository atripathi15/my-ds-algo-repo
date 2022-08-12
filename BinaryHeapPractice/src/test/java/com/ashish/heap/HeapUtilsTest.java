package com.ashish.heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
public class HeapUtilsTest {
	TestUtils testUtils;	

	@InjectMocks
	private HeapUtils heapUtils;

	@BeforeAll
	public void setUp() {
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
	public void heapSortTest() {
		int[] arr = {34,22,11,9,25,48,24,2,4,72,28,15,3};
		int[] sortedArray = {2,3,4,9,11,15,22,24,25,28,34,48,72};
		heapUtils.heapSort(arr);
		System.out.println("sorted array");
		Arrays.stream(arr).forEach(i->System.out.print(i+" "));
		assertArrayEquals(sortedArray, arr);
	}

}
