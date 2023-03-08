package com.naveen.problems.arrays;

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
public class Problem31_NextPermutation {
    public void nextPermutation(int[] a) {
        if (a.length == 1) return;
        int st = a.length - 2;
        while (st >= 0 && a[st] >= a[st + 1]) st--;
        if (st < 0) reverse(a, 0, a.length);
        else {
            int tail = a.length - 1;
            while (st < tail && a[st] >= a[tail]) tail--;
            swap(a, st, tail);
            reverse(a, st + 1, a.length);
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
