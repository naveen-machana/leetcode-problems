package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/minimum-falling-path-sum
* Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly
* below or diagonally left/right. Specifically, the next element from position (row, col) will be
* (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
* */
public class Problem931_MinimumFallingPathSum {
    public static void main(String[] args) {
        Problem931_MinimumFallingPathSum sol = new Problem931_MinimumFallingPathSum();
        int[][] a = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(sol.minFallingPathSum2(a));
    }
    final int[][] moves = {{1, 0}, {1, -1}, {1, 1}};
    public int minFallingPathSum2(int[][] a) {
        Map<String, Integer> dp = new HashMap<>();
        int m = a.length, n = a[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, minSum(a, 0, i, m, n, dp));
        }
        return min;
    }

    private int minSum(int[][] a, int i, int j, int m, int n, Map<String, Integer> dp) {
        if (i == m) return 0;
        String rc = i + ":" + j;
        if (dp.containsKey(rc)) return dp.get(rc);
        int res = Integer.MAX_VALUE;
        for (int[] move : moves) {
            int x = i + move[0], y = j + move[1];
            if (x >= 0 && x <= m && y >= 0 && y < n)
                res = Math.min(res, a[i][j] + minSum(a, x, y, m, n, dp));
        }
        dp.put(rc, res);
        return dp.get(rc);
    }

    // approach 2
    public int minFallingPathSum(int[][] a) {
        int m = a.length, n = a[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[m - 1][i] = a[m - 1][i];

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int one = j > 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int two = dp[i + 1][j];
                int three = j < n - 1 ? dp[i + 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = a[i][j] + Math.min(one, Math.min(two, three));
            }
        }

        for (int i = 0; i < n; i++) min = Math.min(min, dp[0][i]);
        return min;
    }
}
