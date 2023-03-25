package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/coin-change
* You are given an integer array coins representing coins of different denominations and an integer amount
* representing a total amount of money. Return the fewest number of coins that you need to make up that amount.
* If that amount of money cannot be made up by any combination of the coins, return -1.
* You may assume that you have an infinite number of each kind of coin.
*
* Input: coins = [1,2,5], amount = 11
* Output: 3
* Explanation: 11 = 5 + 5 + 1
* */
public class Problem322_CoinChange {
    public int coinChange2(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        int res = minCoins(coins, coins.length, amount, dp);
        return res != Integer.MAX_VALUE ? res : -1;
    }

    private int minCoins(int[] a, int n, int amount, Map<Integer, Integer> dp) {
        if (amount == 0) return 0;
        if (dp.containsKey(amount)) return dp.get(amount);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (amount >= a[i]) {
                int subres = minCoins(a, n, amount - a[i], dp);
                if (subres != Integer.MAX_VALUE)
                    res = Math.min(res, 1 + subres);
            }
        }
        dp.put(amount, res);
        return dp.get(amount);
    }

    //approach2
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

}
