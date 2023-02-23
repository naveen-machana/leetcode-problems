package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/find-the-duplicate-number/
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
* */
public class Problem287_FindDuplicate {
    public int findDuplicate(int[] a) {
        int st = 0, end = a.length - 1, dup = -1;
        while (st <= end) {
            int m = (st + end)/2;

            int count = 0;
            for(int i = 0; i < a.length; i++)
                if (a[i] <= m) count++;

            if (count > m) {
                dup = m;
                end = m - 1;
            }
            else st = m + 1;
        }
        return dup;
    }
}
