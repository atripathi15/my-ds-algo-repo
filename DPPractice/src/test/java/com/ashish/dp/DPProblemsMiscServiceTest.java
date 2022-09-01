package com.ashish.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.dp.service.DPProblemsMiscService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class DPProblemsMiscServiceTest {

	@InjectMocks
	private DPProblemsMiscService dpProblemsMiscService;

	@Test
	public void lisTest() {

		int result = dpProblemsMiscService.getLIS(new int[] { 10, 5, 18, 7, 2, 9 }, 6);
		assertEquals(3, result);

		result = dpProblemsMiscService.getLIS(new int[] { 3, 4, 2, 8, 10 }, 5);
		assertEquals(4, result);

	}
	
	@Test
	public void maxCutTest() {
		int result = dpProblemsMiscService.getMaxCuts(5,1,2,3);
		assertEquals(5, result);
		
		result = dpProblemsMiscService.getMaxCuts(23,12,11,13);
		assertEquals(2, result);
		
		result = dpProblemsMiscService.getMaxCuts(3,2,4,2);
		assertEquals(-1, result);
	}
	
	@Test
	public void getMinCoinsTest() {
		
		int result = dpProblemsMiscService.getMinCoinsDP(new int[]{3,4,1}, 3, 5);
		assertEquals(2, result);
		
		result = dpProblemsMiscService.getMinCoinsDP(new int[]{25,10,5}, 3, 30);
		assertEquals(2, result);
		
		result = dpProblemsMiscService.getMinCoinsDP(new int[]{9,6,5,1}, 4, 11);
		assertEquals(2, result);
		
	}
	
	@Test
	public void getMinEggDropCountTest() {
		int result = dpProblemsMiscService.getMinEggDropCountDP(3, 2);
		assertEquals(2, result);
		
		result = dpProblemsMiscService.getMinEggDropCountDP(10, 2);
		assertEquals(4, result);
	}

}
