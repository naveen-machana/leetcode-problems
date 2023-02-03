package com.naveen.problems.arrays.problem75;

// https://leetcode.com/problems/sort-colors/
// 75. Sort Colors
// Given an array nums with n objects colored red, white, or blue,
// sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
// You must solve this problem without using the library's sort function.
public class Solution {
    public void sortColors(int[] a) {
        int i = 0, j = 0, k = a.length - 1;
        while (j <= k) {
            switch(a[j]) {
                case 0:
                    swap(a, i, j);
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    swap(a, j, k);
                    k--;
                    break;
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
