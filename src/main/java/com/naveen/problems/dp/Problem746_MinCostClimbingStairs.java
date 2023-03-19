package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/min-cost-climbing-stairs/description
* You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
* you can either climb one or two steps. You can either start from the step with index 0, or the step with index 1.
* Return the minimum cost to reach the top of the floor.
* Input: cost = [1,100,1,1,1,100,1,1,100,1]
* Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
* */
public class Problem746_MinCostClimbingStairs {
    // approach 1
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        f(cost, 0, n, dp);
        return Math.min(dp[0], dp[1]);
    }

    private int f(int[] a, int i, int n, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != 0) return dp[i];
        int one = f(a, i + 1, n, dp);
        int two = f(a, i + 2, n, dp);
        dp[i] = a[i] + Math.min(one, two);
        return dp[i];
    }

    // approach 2
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) dp[i] = cost[i];
        for (int i = n - 2; i >= 0; i--) dp[i] = dp[i] + Math.min(dp[i + 1], dp[i + 2]);
        return Math.min(dp[0], dp[1]);
    }
}
