package com.naveen.problems.dp;

import java.util.Arrays;

/*
* https://leetcode.com/problems/unique-paths-ii
* You are given an m x n integer array grid. There is a robot initially located at the top-left corner
* (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
* The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any
* square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.
*
* */
public class Problem63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = g[0][0] == 0 ? 1 : 0;

        for (int i = 1; i < m; i++) dp[i][0] = g[i][0] == 0 ? dp[i - 1][0] : 0;
        for (int i = 1; i < n; i++) dp[0][i] = g[0][i] == 0 ? dp[0][i - 1] : 0;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = g[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;

        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return count2(g, 0, 0, m, n, dp);
    }

    int count2(int[][] g, int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1 && g[i][j] != 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (g[i][j] == 1) return 0;
        int xr = i, yr = j + 1;
        int right = (xr < m && yr < n && g[xr][yr] != 1) ? count2(g, xr, yr, m, n, dp) : 0;
        int xd = i + 1, yd = j;
        int down = (xd < m && yd < n && g[xd][yd] != 1) ? count2(g, xd, yd, m, n, dp) : 0;
        dp[i][j] = right + down;
        return dp[i][j];
    }
}
