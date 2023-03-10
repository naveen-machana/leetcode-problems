package com.naveen.problems.arrays;

// https://leetcode.com/problems/merge-sorted-array/
// 88. Merge Sorted Array
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
// representing the number of elements in nums1 and nums2 respectively.
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
// merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
public class Problem88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k1 = m - 1, k2 = n - 1, temp = m + n - 1;

        while (k1 >= 0 && k2 >= 0) {
            if (nums1[k1] <= nums2[k2]) {
                nums1[temp--] = nums2[k2--];
            }
            else {
                nums1[temp--] = nums1[k1--];
            }
        }

        while (k2 >= 0 && temp >= 0) nums1[temp--] = nums2[k2--];
    }
}
