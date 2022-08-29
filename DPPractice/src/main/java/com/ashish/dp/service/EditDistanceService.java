package com.ashish.dp.service;

import org.springframework.stereotype.Service;

@Service
public class EditDistanceService {
	
	public int getEDRecursive(String s1, String s2, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;

		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return getEDRecursive(s1, s2, m - 1, n - 1);
		} else {
			return 1 + Math.min(getEDRecursive(s1, s2, m, n - 1),
					Math.min(getEDRecursive(s1, s2, m - 1, n), getEDRecursive(s1, s2, m - 1, n - 1)));
		}
	}
	
	public int getEDDP(String s1, String s2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}
		return dp[m][n];
	}

}
