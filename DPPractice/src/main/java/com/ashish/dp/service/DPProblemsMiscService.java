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
	
	public int getMaxCuts(int n, int a, int b, int c) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = -1;
			if (i - a >= 0)
				dp[i] = Math.max(dp[i], dp[i - a]);
			if (i - b >= 0)
				dp[i] = Math.max(dp[i], dp[i - b]);
			if (i - c >= 0)
				dp[i] = Math.max(dp[i], dp[i - c]);

			if (dp[i] != -1) {
				dp[i]++;
			}
		}
		return dp[n];
	}
	
	/**
	 * Get minimum number of coins required to reach a given value
	 */
	public int getMinCoinsDP(int[] coins, int n, int value) {
		int[] dp = new int[value + 1];
		dp[0] = 0;
		for (int i = 1; i <= value; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= value; i++) {

			for (int j = 0; j < n; j++) {
				if (coins[j] <= i) {
					int sub_res = dp[i - coins[j]];
					dp[i] = Math.min(dp[i], sub_res + 1);
				}
			}
		}
		return dp[value];
	}
	
	/**
	 * Time Complexity O(f2*e)
	 * Space Complexity O(f*e)
	 * @param f : no of floors
	 * @param e : no of eggs
	 * @return minimum number of egg drops required to find the egg breaking floor
	 */
	public int getMinEggDropCountDP(int f, int e) {
		int[][] dp = new int[f+1][e+1];
		for(int i=1;i<=e;i++) {
			dp[0][i]=0;
			dp[1][i]=1;
		}
		for(int j=1;j<=f;j++) dp[j][1]=j;
		for(int i=2;i<=f;i++)
			for(int j=2;j<=e;j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for(int x=1;x<=i;x++)
				dp[i][j] = Math.min(dp[i][j],1+Math.max(dp[x-1][j-1], dp[i-x][j]));
			}
		return dp[f][e];		
	}
	

}
