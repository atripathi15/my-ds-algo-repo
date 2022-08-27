package com.ashish.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.dp.service.FibonacciService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class FibonacciServiceTest {
	
	@InjectMocks
	private FibonacciService fibonacciService;
	
	@Test
	public void fibonacciTest() {
		int result = fibonacciService.fibonacciRecursive(5);
		assertEquals(5, result);
		result = fibonacciService.fibonacciRecursive(6);
		assertEquals(8, result);
		
		result = fibonacciService.fibonacciTopDown(5);
		assertEquals(5, result);
		result = fibonacciService.fibonacciTopDown(6);
		assertEquals(8, result);
		
		result = fibonacciService.fibonacciTabulation(5);
		assertEquals(5, result);
		result = fibonacciService.fibonacciTabulation(6);
		assertEquals(8, result);
		
	}

}
