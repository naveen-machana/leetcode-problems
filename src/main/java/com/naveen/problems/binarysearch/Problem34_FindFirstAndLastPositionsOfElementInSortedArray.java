package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a
// given target value.
//
// If target is not found in the array, return [-1, -1].
//
// You must write an algorithm with O(log n) runtime complexity.
public class Problem34_FindFirstAndLastPositionsOfElementInSortedArray {
    public int[] searchRange(int[] a, int target) {
        int st = 0, end = a.length - 1;
        int first = -1;
        while (st <= end) {
            int m = (st + end)/2;
            if (a[m] == target) {
                first = m;
                end = m - 1;
            }
            else if (a[m] > target) end = m - 1;
            else st = m + 1;
        }

        int last = -1;
        st = 0; end = a.length - 1;
        while (st <= end) {
            int m = (st + end)/2;
            if (a[m] == target) {
                last = m;
                st = m + 1;
            }
            else if (a[m] > target) end = m - 1;
            else st = m + 1;
        }
        return new int[]{first, last};
    }
}
