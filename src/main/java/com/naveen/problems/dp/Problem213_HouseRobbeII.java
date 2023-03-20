package com.naveen.problems.dp;

// https://leetcode.com/problems/house-robber-ii
/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
* All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
* Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
* adjacent houses were broken into on the same night. Given an integer array nums representing the amount of money of
* each house, return the maximum amount of money you can rob tonight without alerting the police.
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */
public class Problem213_HouseRobbeII {
    public static void main(String[] args) {
        Problem213_HouseRobbeII sol = new Problem213_HouseRobbeII();
        int[] a = {1,2,3,1};
        sol.rob(a);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int st, int end) {
        int[] dp = new int[end - st + 1];
        dp[0] = nums[st];
        if (dp.length > 1) dp[1] = Math.max(nums[st], nums[st + 1]);
        for (int i = 2; i < dp.length; i++)
            dp[i] = Math.max(nums[st + i] + dp[i - 2], dp[i - 1]);
        return dp[dp.length - 1];
    }

    private int rob2(int[] a, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + a[j];
            exclude = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }
}
