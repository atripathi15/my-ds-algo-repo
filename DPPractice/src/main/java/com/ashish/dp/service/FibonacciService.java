package com.ashish.dp.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {
	
	
	
	/* Time complexity is Exponential */
	public int fibonacciRecursive(int n) {
		if (n == 0 || n == 1)
			return n;
		else {
			return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
		}
	}
	
	/**
	 * Memoization based solution
	 *  Time complexity is theta(n) 
	*/
	public int fibonacciTopDown(int n) {
		int[] memo = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			memo[i] = -1;
		}
		return fibonacciMemo(n, memo);
	}
	
	public int fibonacciMemo(int n, int[] memo) {
		if (memo[n] == -1) {
			int result;
			if (n == 0 || n == 1)
				result = n;
			else
				result = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
			memo[n] = result;
		}
		return memo[n];
	}
	
	/**
	 * Tabulation based solution
	 *  Time complexity is theta(n) 
	*/
	public int fibonacciTabulation(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

}
