package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/perfect-squares
* Given an integer n, return the least number of perfect square numbers that sum to n.
* A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
* with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
* Input: n = 12
* Output: 3
* Explanation: 12 = 4 + 4 + 4.
* */
public class Problem279_PerfectSquares {
    // approach - 1
    public int numSquares2(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        return ways(n, dp);
    }

    private int ways(int n, Map<Integer, Integer> dp) {
        if (n == 0) return 0;
        if (dp.containsKey(n)) return dp.get(n);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int subres = ways(n - i * i, dp);
            res = Math.min(res, 1 + subres);
        }
        dp.put(n, res);
        return dp.get(n);
    }

    // approach - 2
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}
