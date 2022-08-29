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

}
