package com.naveen.problems.arrays;

/*
* https://leetcode.com/problems/move-zeroes/
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of
* the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*
* Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
* */
public class Problem283_MoveZeros {
    public void moveZeroes(int[] a) {
        int st = -1, tail = 0, n = a.length;
        while (tail < n) {
            if (a[tail] != 0)
                swap(a, ++st, tail);
            tail++;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
