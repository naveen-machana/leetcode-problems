package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/search-insert-position/
// Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
// You must write an algorithm with O(log n) runtime complexity.
// Input: nums = [1,3,5,6], target = 2
// Output: 1
public class Problem35_SearchInsertPosition {
    public int searchInsert(int[] a, int target) {
        int st = 0, end = a.length;

        while (st < end) {
            int m = (st + end)/2;
            if (a[m] == target) return m;
            if (a[m] > target) end = m;
            else st = m + 1;
        }
        return st;
    }
}
