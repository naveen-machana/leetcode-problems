package com.naveen.problems.binarysearch;

/*
https://leetcode.com/problems/find-peak-element/
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly
greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.
* */
public class Problem162_PeakElement {
    public int findPeakElement(int[] a) {
        int l = 0, r = a.length - 1, n = a.length;
        while (l <= r) {
            int m = (l + r)/2;
            if ((m == 0 || a[m - 1] < a[m]) && (m == n - 1 || a[m] > a[m + 1])) return m;
            else if (m > 0 && a[m - 1] > a[m]) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }


}
