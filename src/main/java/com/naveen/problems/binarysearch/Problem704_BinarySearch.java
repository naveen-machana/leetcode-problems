package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/binary-search
* Given an array of integers nums which is sorted in ascending order, and an integer target,
* write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
* You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
* */
public class Problem704_BinarySearch {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int m = (lo + hi)/2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) lo = m + 1;
            else hi = m - 1;
        }
        return -1;
    }
}
