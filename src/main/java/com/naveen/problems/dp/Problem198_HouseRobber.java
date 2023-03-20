package com.naveen.problems.dp;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
* stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
* connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
* Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
* can rob tonight without alerting the police.
* Input: nums = [1,2,3,1]
* Output: 4
* Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
* Total amount you can rob = 1 + 3 = 4.
* */
public class Problem198_HouseRobber {
    // approach 1
    public int rob3(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxSum(nums, nums.length, dp);
    }

    private int maxSum(int[] a, int n, int[] dp) {
        if (n == 1) return a[0];
        if (n == 2) return Math.max(a[0], a[1]);
        if (dp[n - 1] != -1) return dp[n - 1];
        dp[n - 1] = Math.max(a[n - 1] + maxSum(a, n - 2, dp), maxSum(a, n - 1, dp));
        return dp[n - 1];
    }

    //approach 2
    public int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        return dp[nums.length - 1];
    }

    //approach 3
    public int rob(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = sum2;
            sum2 = Math.max(nums[i] + sum1, sum2);
            sum1 = temp;
        }
        return sum2;
    }
}
