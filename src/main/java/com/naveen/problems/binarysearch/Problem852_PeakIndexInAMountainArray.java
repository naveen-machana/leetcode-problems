package com.naveen.problems.binarysearch;

// https://leetcode.com/problems/peak-index-in-a-mountain-array
public class Problem852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] a) {
        int st = 0, end = a.length - 1, n = a.length - 1;
        while (st < end) {
            int m = (st + end)/2;
            if ((m == 0 || a[m] > a[m - 1]) &&
                    (m == n || a[m] > a[m + 1])) {
                return m;
            }
            else if (a[m] < a[m - 1]) end = m;
            else st = m + 1;
        }
        return -1;
    }
}
