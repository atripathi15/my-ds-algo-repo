package com.ashish.heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	@InjectMocks
	private HeapUtils heapUtils;

	@BeforeAll
	public void setUp() {
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
	
	@Test
	public void kSortedArrayTest() {
		int[] arr = {9,8,7,18,19,17};
		int[] sortedArray = {7,8,9,17,18,19};
		heapUtils.sortKSortedArray(arr, 2);
		System.out.println("sorted array");
		Arrays.stream(arr).forEach(i->System.out.print(i+" "));
		assertArrayEquals(sortedArray, arr);
	}
	
	@Test
	public void findKLargestUsingMaxHeapTest() {
		int[] arr = {34,22,11,9,25,48,24,2,4,72,28,15,3};
		int[] expectedResult = {72,48,34,28};
		int[] result = heapUtils.findKLargestUsingMaxHeap(arr, 4);
		System.out.println("max 4 elements array");
		Arrays.stream(result).forEach(i->System.out.print(i+" "));
		assertArrayEquals(result, expectedResult);		
	}
	
	@Test
	public void findKLargestUsingMinHeapTest() {
		int[] arr = {34,22,11,9,25,48,24,2,4,72,28,15,3};
		int[] expectedResult = {28,34,48,72};
		int[] result = heapUtils.findKLargestUsingMinHeap(arr, 4);
		System.out.println("max 4 elements array");
		Arrays.stream(result).forEach(i->System.out.print(i+" "));
		assertArrayEquals(result, expectedResult);		
	}
	
	@Test
	public void findKClosetTest() {
		int[] arr = {34,22,11,9,25,48,24,2,4,72,28,15,3};
		//int[] expectedResult = {28,34,48,72};
		int[] result = heapUtils.findKClosest(arr, 100, 4);
		System.out.println("closest 4 elements array");
		Arrays.stream(result).forEach(i->System.out.print(i+" "));
		//assertArrayEquals(result, expectedResult);		
	}
	
	@Test
	public void mergeKSortedArraysTest() {
		List<Integer> list1 = Arrays.asList(12,18,24,29,35);
		List<Integer> list2 = Arrays.asList(2,8,19,29);
		List<Integer> list3 = Arrays.asList(5,30,36,42);
		List<List<Integer>> inputList = new ArrayList<>();
		inputList.add(list1);
		inputList.add(list2);
		inputList.add(list3);
		List<Integer> result = heapUtils.mergeKSortedArrays(inputList);
		assertNotNull(result);
		assertEquals(list1.size()+list2.size()+list3.size(), result.size());
		assertEquals(42,result.get(result.size()-1));
		assertEquals(2,result.get(0));
		System.out.println("merged list: "+result.toString());		
	}
	
	@Test
	public void getArrayMedianTest() {
		int[] arr = {10,25,12,28,20};
		List<Double> median = heapUtils.getArrayMedian(arr);
		System.out.println("Median:");
		median.stream().forEach(d->System.out.print(d+" "));
		
	}

}
