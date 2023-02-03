package com.naveen.problems.arrays.problem31;

// https://leetcode.com/problems/next-permutation/
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//For example, for arr = [1,2,3], the following are all the permutations of
// arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
// More formally, if all the permutations of the array are sorted in one container according to their lexicographical
// order, then the next permutation of that array is the permutation that follows it in the sorted container.
// If such arrangement is not possible, the array must be rearranged as the lowest possible order
// (i.e., sorted in ascending order).
//
//For example, the next permutation of arr = [1,2,3] is [1,3,2].
//Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a
// lexicographical larger rearrangement.
//Given an array of integers nums, find the next permutation of nums.
//
//The replacement must be in place and use only constant extra memory.
public class Solution {
    public void nextPermutation(int[] a) {
        if (a.length <= 1) return;
        int n = a.length, k, l;

        for (k = n - 2; k >= 0; k--) {
            if (a[k] < a[k + 1]) break;
        }

        if (k < 0) reverse(a, 0, n);
        else {
            for (l = n - 1; l > k; l--) {
                if (a[l] > a[k]) break;
            }
            swap(a, l, k);
            reverse(a, k + 1, n);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void reverse(int[] a, int i, int n) {
        int st = i, end = n - 1;
        while (st < end) {
            swap(a, st, end);
            st++;
            end--;
        }
    }
}
