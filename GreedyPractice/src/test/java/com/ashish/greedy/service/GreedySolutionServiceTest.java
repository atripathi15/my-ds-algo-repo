package com.ashish.greedy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.greedy.model.Activity;
import com.ashish.greedy.model.Item;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class GreedySolutionServiceTest {
	
	@InjectMocks
	private GreedySolutionService greedySolutionService;
	
	@Test
	public void activitySelectionTest() {
		Activity[] arr = {new Activity(1, 4), new Activity(2, 5), new Activity(4, 12), new Activity(10, 14), new Activity(12, 17)};
		int result = greedySolutionService.getMaxActivity(arr);
		assertEquals(3, result);
		
		Activity[] arr2 = {new Activity(1, 7), new Activity(2, 6), new Activity(3, 12), new Activity(6, 14), new Activity(15, 17)};
		result = greedySolutionService.getMaxActivity(arr2);
		assertEquals(3, result);
	}
	
	@Test
	public void fractionalKnapsackTest() {
		Item[] item = { new Item(50, 600), new Item(20, 500), new Item(30, 400)};
		double result = greedySolutionService.fractionalKnapSack(item, 70);
		assertEquals(1140.0, result);
	}

}
