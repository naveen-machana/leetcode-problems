package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/minimum-path-sum
* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
* which minimizes the sum of all numbers along its path.
* Note: You can only move either down or right at any point in time.
* */
public class Problem64_MinimumPathSum {
    public int minPathSum(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = g[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = g[i][0] + dp[i - 1][0];
        for (int i = 1; i < n; i++) dp[0][i] = g[0][i] + dp[0][i - 1];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = g[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

        return dp[m - 1][n - 1];
    }
}
