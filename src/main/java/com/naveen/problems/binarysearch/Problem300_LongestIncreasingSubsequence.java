package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/longest-increasing-subsequence/
/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
* */
public class Problem300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Problem300_LongestIncreasingSubsequence sol = new Problem300_LongestIncreasingSubsequence();
        sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (dp[len - 1] < a[i]) {
                dp[len++] = a[i];
            }
            else {
                int p = position(dp, a[i], len);
                dp[p] = a[i];
            }
        }
        return len;
    }

    private int position(int[] a, int x, int n) {
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r)/2;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
