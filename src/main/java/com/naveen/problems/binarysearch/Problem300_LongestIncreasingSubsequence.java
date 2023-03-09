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
        int n = a.length, lp = 0;
        int[] lis = new int[n]; lis[0] = a[0];

        for (int i = 1; i < n; i++) {
            if (a[i] > lis[lp]) lis[lp++] = a[i];
            else {
                int pos = position(lis, a[i], lp);
                lis[pos] = a[i];
            }
        }
        return lp;
    }
    private int position(int[] a, int target, int end) {
        int l = 0, r = end;
        while (l < r) {
            int m = (l + r)/2;
            if (a[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
