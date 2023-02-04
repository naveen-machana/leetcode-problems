package com.naveen.problems.arrays.problem493;

// https://leetcode.com/problems/reverse-pairs/
// 493. Reverse Pairs
// Given an integer array nums, return the number of reverse pairs in the array.
//
// A reverse pair is a pair (i, j) where:
//
// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,3,2,3,1};
        s.reversePairs(a);
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }

    private int mergesort(int[] a, int st, int end) {
        if (st >= end) return 0;
        int mid = (st + end)/2;
        int l = mergesort(a, st, mid);
        int r = mergesort(a, mid + 1, end);
        int m = merge(a, st, mid, end);
        return l + r + m;
    }

    private int merge(int[] a, int l, int m, int r) {
        int count = 0, j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && a[i] > (long)2 * a[j]) j++;
            count += (j - m - 1);
        }

        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i = 0, k = l;
        for (; i < n1; i++) left[i] = a[l + i];
        for (j = 0; j < n2; j++) right[j] = a[j + m + 1];

        i = 0; j = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                a[k++] = left[i++];
            else
                a[k++] = right[j++];
        }
        while (i < n1) a[k++] = left[i++];
        while (j < n2) a[k++] = right[j++];
        return count;
    }
}
