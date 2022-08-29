package com.ashish.dp.service;

import org.springframework.stereotype.Service;

@Service
public class DPProblemsMiscService {
	
	public int getLIS(int[] arr, int n) {
		int result;
		int[] lis = new int[n];
		lis[0] = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
		result = lis[0];
		for (int i = 1; i < n; i++) {
			result = Math.max(result, lis[i]);
		}

		return result;
	}
	

}
