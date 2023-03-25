package com.naveen.problems.dp;

import java.util.Arrays;

/*
* https://leetcode.com/problems/longest-increasing-subsequence
* Given an integer array nums, return the length of the longest strictly increasing subsequence.
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
* */
public class Problem300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Problem300_LongestIncreasingSubsequence sol = new Problem300_LongestIncreasingSubsequence();
        int[] a = {10,9,2,5,3,7,101,18};
        System.out.println(sol.lengthOfLIS2(a));
    }

    public int lengthOfLIS(int[] a) {
        int n = a.length, max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS2(int[] a) {
        int n = a.length, p = 1;
        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > dp[p - 1]) dp[p++] = a[i];
            else {
                dp[ceil(dp, 0, p - 1, a[i])] = a[i];
            }
        }
        return p;
    }

    private int ceil(int[] dp, int st, int end, int x) {
        while (st < end) {
            int m = (st + end)/2;
            if (dp[m] == x) return m;
            if (dp[m] > x) end = m;
            else st = m + 1;
        }
        return st;
    }
}
