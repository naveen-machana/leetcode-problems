package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/maximal-square
* Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
* */
public class Problem221_MaximalSquare {
    public int maximalSquare(char[][] a) {
         int m = a.length, n = a[0].length, max = 0;
         int[][] dp = new int[m][n];
         for (int i = m - 1; i >= 0; i--) {
             dp[i][n - 1] = a[i][n - 1] - '0';
             max = Math.max(max, dp[i][n - 1]);
         }
         for (int i = n - 1; i >= 0; i--) {
             dp[m - 1][i] = a[m - 1][i] - '0';
             max = Math.max(max, dp[m - 1][i]);
         }

         for (int i = m - 2; i >= 0; i--) {
             for (int j = n - 2; j >= 0; j--) {
                 if (a[i][j] == '1') {
                     dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                     max = Math.max(max, dp[i][j]);
                 }
             }
         }

         return max * max;
    }
}
