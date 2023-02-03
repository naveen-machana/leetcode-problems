package com.naveen.problems.arrays.problem48;

// https://leetcode.com/problems/rotate-image/
// 48. Rotate Image
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.
public class Solution {
    public void rotate(int[][] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int st = 0, end = n - 1;
            while (st < end) {
                swap(a[i], st, end);
                st++;
                end--;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
