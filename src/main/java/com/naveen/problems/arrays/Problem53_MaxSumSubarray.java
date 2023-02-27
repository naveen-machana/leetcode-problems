package com.naveen.problems.arrays;

// https://leetcode.com/problems/maximum-subarray/
// 53. Maximum Subarray
// Given an integer array nums, find the subarray with the largest sum, and return its sum.
public class Problem53_MaxSumSubarray {
    public int maxSubArray(int[] a) {
        int n = a.length;
        int maxSoFar = a[0], sum = a[0], curMax;
        for (int i = 1; i < n; i++) {
            curMax = Math.max(a[i], sum + a[i]);
            maxSoFar = Math.max(curMax, maxSoFar);
            sum = curMax;
        }
        return maxSoFar;
    }
}
