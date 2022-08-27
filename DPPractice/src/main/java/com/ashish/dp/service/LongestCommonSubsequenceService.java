package com.ashish.dp.service;

import org.springframework.stereotype.Service;

@Service
public class LongestCommonSubsequenceService {
	
	/**
	 Time Complexity - Exponential O(2 pow n)
	 */
	public int lcsRecursive(String s1, String s2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + lcsRecursive(s1, s2, m - 1, n - 1);
		} else {
			return Math.max(lcsRecursive(s1, s2, m - 1, n), lcsRecursive(s1, s2, m, n - 1));
		}
	}
	
	/**
	 Time Complexity - DP Memoization based approach theta(m*n)
	 */
	public int lcsDPMemo(String s1, String s2, int m, int n) {
		int[][] memo = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				memo[i][j] = -1;
		return lcsMemo(s1, s2, m, n, memo);
	}
	
	public int lcsMemo(String s1, String s2, int m, int n, int[][] memo) {
		if (memo[m][n] == -1) {
			if (m == 0 || n == 0) {
				memo[m][n] = 0;
			} else {
				if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
					memo[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, memo);
				} else {
					memo[m][n] = Math.max(lcsMemo(s1, s2, m - 1, n, memo), lcsMemo(s1, s2, m, n - 1, memo));
				}
			}
		}
		return memo[m][n];
	}
	
	/**
	 Time Complexity - DP Tabulation based approach theta(m*n)
	 */
	public int lcsTabulation(String s1, String s2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			dp[i][0] = 0;
		for (int j = 0; j <= n; j++)
			dp[0][j] = 0;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		return dp[m][n];
	}

}
