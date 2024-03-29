package com.naveen.problems.dp;

// https://leetcode.com/problems/unique-paths/
// 62. Unique Paths
// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
// The robot can only move either down or right at any point in time.
//
// Given the two integers m and n, return the number of possible unique paths that the robot can take
// to reach the bottom-right corner.

public class Problem62_UniquePaths {
    static int[][] moves = {{1, 0}, {0, 1}};
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return count(0, 0, m, n, dp);
    }

    private int count(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 || j == n - 1) return 1;
        if (dp[i][j] != 0 ) return dp[i][j];
        int res = 0;
        for (int[] move: moves) {
            if (isValid(i + move[0], j + move[1], m, n)) {
                res += count(i + move[0], j + move[1], m, n, dp);
            }
        }

        dp[i][j] = res;
        return dp[i][j];
    }

    private int count (int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
