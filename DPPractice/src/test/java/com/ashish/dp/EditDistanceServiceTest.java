package com.ashish.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.dp.service.EditDistanceService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class EditDistanceServiceTest {

	@InjectMocks
	private EditDistanceService editDistanceService;

	@Test
	public void getEDTest() {
		int result = editDistanceService.getEDRecursive("cat", "cut", 3, 3);
		assertEquals(1, result);

		result = editDistanceService.getEDRecursive("geek", "geeks", 4, 5);
		assertEquals(1, result);

		result = editDistanceService.getEDRecursive("saturday", "sunday", 8, 6);
		assertEquals(3, result);
		
		result = editDistanceService.getEDDP("cat", "cut", 3, 3);
		assertEquals(1, result);

		result = editDistanceService.getEDDP("geek", "geeks", 4, 5);
		assertEquals(1, result);

		result = editDistanceService.getEDDP("saturday", "sunday", 8, 6);
		assertEquals(3, result);

	}

}
