package com.naveen.problems.problem2169.sorting;

/*
https://leetcode.com/problems/first-missing-positive/
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

* */
public class Problem41_FirstMissingPositive {
    public static void main(String[] args) {
        Problem41_FirstMissingPositive sol = new Problem41_FirstMissingPositive();
        int[] a = {3,4,-1,1};
        System.out.println(sol.firstMissingPositive(a));
    }
    public int firstMissingPositive(int[] a) {
        for (int i = 0; i < a.length; i++)
            while (a[i] > 0 && a[i] <= a.length && a[i] != a[a[i] - 1])
                swap(a, i, a[i] - 1);

        for (int i = 0; i < a.length; i++)
            if (a[i] - 1 != i) return i + 1;

        return a.length + 1;
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
