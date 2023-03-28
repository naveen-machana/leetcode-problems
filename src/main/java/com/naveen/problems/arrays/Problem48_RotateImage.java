package com.naveen.problems.arrays;

// https://leetcode.com/problems/rotate-image/description/
// first write swapping without using i
// include i later to cover for all the elements within a row.
// refer elements as top-left, top-right, bottom-left, bottom-right
public class Problem48_RotateImage {
    public void rotate(int[][] a) {
        int n = a.length;
        int l = 0, r = n - 1;
        while (l < r) { // this is to cover all the layers
            for (int i = 0; i < r - l; i++) { // this is to cover all the elements within a row
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
