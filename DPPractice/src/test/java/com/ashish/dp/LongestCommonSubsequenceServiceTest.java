package com.ashish.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.dp.service.LongestCommonSubsequenceService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class LongestCommonSubsequenceServiceTest {
	
	@InjectMocks
	private LongestCommonSubsequenceService lcsService;
	
	@Test
	public void testLCS() {
		
		int lcs = lcsService.lcsRecursive("ABCDGH", "AEDFHR", 6, 6);
		assertEquals(3, lcs);
		lcs = lcsService.lcsRecursive("AGGTAB", "GXTXAYB", 6, 7);
		assertEquals(4, lcs);
		lcs = lcsService.lcsRecursive("xyz", "xyz", 3, 3);
		assertEquals(3, lcs);
		lcs = lcsService.lcsRecursive("xy", "abc", 2, 3);
		assertEquals(0, lcs);
		lcs = lcsService.lcsRecursive("xyz", "", 3, 0);
		assertEquals(0, lcs);
		
		lcs = lcsService.lcsDPMemo("ABCDGH", "AEDFHR", 6, 6);
		assertEquals(3, lcs);
		lcs = lcsService.lcsDPMemo("AGGTAB", "GXTXAYB", 6, 7);
		assertEquals(4, lcs);
		lcs = lcsService.lcsDPMemo("xyz", "xyz", 3, 3);
		assertEquals(3, lcs);
		lcs = lcsService.lcsDPMemo("xy", "abc", 2, 3);
		assertEquals(0, lcs);
		lcs = lcsService.lcsDPMemo("xyz", "", 3, 0);
		assertEquals(0, lcs);
		
		lcs = lcsService.lcsTabulation("ABCDGH", "AEDFHR", 6, 6);
		assertEquals(3, lcs);
		lcs = lcsService.lcsTabulation("AGGTAB", "GXTXAYB", 6, 7);
		assertEquals(4, lcs);
		lcs = lcsService.lcsTabulation("xyz", "xyz", 3, 3);
		assertEquals(3, lcs);
		lcs = lcsService.lcsTabulation("xy", "abc", 2, 3);
		assertEquals(0, lcs);
		lcs = lcsService.lcsTabulation("xyz", "", 3, 0);
		assertEquals(0, lcs);
		
	}

}
