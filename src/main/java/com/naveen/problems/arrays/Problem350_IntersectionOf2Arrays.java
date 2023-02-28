package com.naveen.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any
order.

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted

* */
public class Problem350_IntersectionOf2Arrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        List<Integer> res = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                res.add(nums1[i]);
                i++; j++;
            }
        }
        int[] resa = new int[res.size()]; int k = 0;
        for (int e : res) resa[k++] = e;
        return resa;
    }
}
