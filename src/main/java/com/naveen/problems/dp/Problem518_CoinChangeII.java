package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/coin-change-ii
* You are given an integer array coins representing coins of different denominations and an integer amount
* representing a total amount of money. Return the number of combinations that make up that amount.
* If that amount of money cannot be made up by any combination of the coins, return 0.
* You may assume that you have an infinite number of each kind of coin.
* The answer is guaranteed to fit into a signed 32-bit integer.
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
* */
public class Problem518_CoinChangeII {
    public int change2(int amount, int[] coins) {
        Map<String, Integer> dp = new HashMap<>();
        return ways(coins, coins.length, amount, dp);
    }

    int ways(int[] a, int n, int amount, Map<String, Integer> dp) {
        if (amount == 0) return 1;
        if (n == 0) return 0;
        String key = amount + ":" + n;
        if (dp.containsKey(key)) return dp.get(key);
        int res = 0;
        if (a[n - 1] > amount)
            res = ways(a, n - 1, amount, dp);
        else res = ways(a, n, amount - a[n - 1], dp) + ways(a, n - 1, amount, dp);
        dp.put(key, res);
        return dp.get(key);
    }

    //approach 2
    public int change(int amount, int[] coins) {
        int n = coins.length, m = amount;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[0][i] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= coins[j - 1]) dp[i][j] += dp[i - coins[j - 1]][j];
            }
        }

        return dp[m][n];
    }
}
