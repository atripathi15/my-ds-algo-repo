package com.ashish.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.dp.service.CoinChangeCountCombinationsService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CoinChangeCountCombinationsServiceTest {
	
	@InjectMocks
	CoinChangeCountCombinationsService coinChangeCountCombinationsService;
	
	@Test	
	public void getCoinChangeCountTest() {
		int[] coins= {2,5,3,6};
		int[] coins2= {1,2,3};
		
		int result = coinChangeCountCombinationsService.getCount(coins, 4, 10);
		assertEquals(5, result);
		result = coinChangeCountCombinationsService.getCount(coins2, 3, 4);
		assertEquals(4, result);
		
		
		result = coinChangeCountCombinationsService.getCountDP(coins, 4, 10);
		assertEquals(5, result);
		
		result = coinChangeCountCombinationsService.getCountDP(coins2, 3, 4);
		assertEquals(4, result);
	}
		

}
