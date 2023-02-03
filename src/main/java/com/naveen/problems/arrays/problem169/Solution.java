package com.naveen.problems.arrays.problem169;

// https://leetcode.com/problems/majority-element/
// 169. Majority Element
// Given an array nums of size n, return the majority element.
//
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array
public class Solution {
    public int majorityElement(int[] a) {
        int count = 0, candidate = -1, n = a.length;
        for (int i = 0; i < n; i++) {
            if (count == 0) candidate = a[i];
            count += (candidate == a[i] ? 1 : -1);
        }
        return candidate;
    }
}
