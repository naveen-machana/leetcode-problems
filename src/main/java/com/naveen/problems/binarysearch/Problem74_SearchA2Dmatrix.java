package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/
// 74. Search a 2D Matrix
// You are given an m x n integer matrix matrix with the following two properties:
//
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
//
// You must write a solution in O(log(m * n)) time complexity.
// 1 2   3  4
// 5 6   7  8
// 9 10 11 12
// 10 / 4, 10
public class Problem74_SearchA2Dmatrix {
    public boolean searchMatrix(int[][] a, int target) {
        int m = a.length, n = a[0].length;
        int st = 0, end = m * n - 1;

        while (st <= end) {
            int mid = (st + end)/ 2;
            if (a[mid / n][mid % n] == target) return true;
            else if (a[mid / n][mid % n] < target) st = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}
