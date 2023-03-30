package com.naveen.problems.binarysearch;

import java.util.Arrays;

/*
* https://leetcode.com/problems/check-if-n-and-its-double-exist
Given an array arr of integers, check if there exist two indices i and j such that :
i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
*
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
* */
public class Problem1346_CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            int l = 0, r = a.length - 1;
            while (l <= r) {
                int m = (l + r)/2;
                if (a[m] == 2 * a[i] && i != m) return true;
                else if (a[m] > 2 * a[i]) r = m - 1;
                else l = m + 1;
            }
        }
        return false;
    }
}
