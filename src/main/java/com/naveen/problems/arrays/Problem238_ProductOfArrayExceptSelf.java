package com.naveen.problems.arrays;

/*
* https://leetcode.com/problems/product-of-array-except-self/description/
* */
public class Problem238_ProductOfArrayExceptSelf {
    // approach - 1
    public int[] productExceptSelf2(int[] a) {
        int n = a.length;
        int[] left = new int[n], right = new int[n], res = new int[n];
        left[0] = 1; right[n - 1] = 1;
        for (int i = 1; i < n; i++) left[i] = left[i - 1] * a[i - 1];
        for (int i = n - 2; i >= 0; i--) right[i] = a[i + 1] * right[i + 1];
        for (int i = 0; i < n; i++) res[i] = left[i] * right[i];
        return res;
    }
    // approach - 2
    public int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        res[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) res[i] = a[i + 1] * res[i + 1];
        int left = a[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i] * left;
            left *= a[i];
        }
        return res;
    }
}
