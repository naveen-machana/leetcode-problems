package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix-ii
/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

public class Problem240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] m, int target) {
        int r = 0, c = m[0].length - 1;
        while (r < m.length && c >= 0) {
            if (m[r][c] == target) return true;
            else if (m[r][c] > target) c = c - 1;
            else r = r + 1;
        }
        return false;
    }
}
