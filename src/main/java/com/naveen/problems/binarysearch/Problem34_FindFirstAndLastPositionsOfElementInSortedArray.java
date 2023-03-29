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
        int l = 0, r = a.length - 1;
        int[] res = {-1, -1};
        while (l <= r) {
            int m = (l + r)/2;
            if (a[m] == target) {
                res[0] = m;
                r = m - 1;
            }
            else if (a[m] > target) r = m - 1;
            else l = m + 1;
        }
        if (res[0] == -1) return res;
        l = res[0]; r = a.length - 1;
        while (l <= r) {
            int m = (l + r)/2;
            if (a[m] == target) {
                res[1] = m;
                l = m + 1;
            }
            else r = m - 1;
        }
        return res;
    }
}
