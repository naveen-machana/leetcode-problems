package com.naveen.problems.arrays;

// https://leetcode.com/problems/rotate-image/description/
public class Problem48_RotateImage {
    public void rotate(int[][] a) {
        int n = a.length;
        int l = 0, r = n - 1;
        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int top = l, bottom = r;
                int topleft = a[top][l + i];
                a[top][l + i] = a[bottom - i][l];
                a[bottom - i][l] = a[bottom][r - i];
                a[bottom][r - i] = a[top + i][r];
                a[top + i][r] = topleft;
            }
            l++; r--;
        }
    }
}
