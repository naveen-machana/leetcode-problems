package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// There is an integer array nums sorted in ascending order (with distinct values).
//
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
// such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
// or -1 if it is not in nums.
//
//You must write an algorithm with O(log n) runtime complexity.

public class Problem33_SearchInASortedAndRotatedArray {
    public static void main(String[] args) {
        Problem33_SearchInASortedAndRotatedArray sol = new Problem33_SearchInASortedAndRotatedArray();
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    public int search(int[] a, int target) {
        int n = a.length;
        int st = 0, end = n - 1;
        while (st < end) {
            int m = (st + end) / 2;
            if (a[m] > a[n - 1]) st = m + 1;
            else end = m;
        }
        int p = st; st = 0; end = n - 1;
        while (st <= end) {
            int m = (st + end)/2;
            int rm = (m + p) % n;
            if (a[rm] == target) return rm;
            else if (a[rm] > target) end = m - 1;
            else st = m + 1;
        }
        return -1;
    }
}
