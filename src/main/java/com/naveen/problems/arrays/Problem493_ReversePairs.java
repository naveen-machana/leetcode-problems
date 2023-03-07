package com.naveen.problems.arrays;

import java.util.LinkedList;

// https://leetcode.com/problems/reverse-pairs/
// 493. Reverse Pairs
// Given an integer array nums, return the number of reverse pairs in the array.
//
// A reverse pair is a pair (i, j) where:
//
// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
public class Problem493_ReversePairs {
    public static void main(String[] args) {
        Problem493_ReversePairs s = new Problem493_ReversePairs();
        int[] a = {1,3,2,3,1};
        System.out.println(s.reversePairs(a));
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }

    private int mergesort(int[] nums, int st, int end) {
        if (st >= end) return 0;
        int mid = (st + end)/2;
        int left = mergesort(nums, st, mid);
        int right = mergesort(nums, mid + 1, end);
        int merged = merge(nums, st, mid, end);
        return left + right + merged;
    }

    private int merge(int[] nums, int st, int mid, int end) {
        int k1 = st, k2 = mid + 1, count = 0;
        for (; k1 <= mid; k1++) {
            while (k2 <= end && nums[k1] > (long)2 * nums[k2]) {
                count += (mid - k1 + 1);
                k2++;
            }
        }
        k1 = st; k2 = mid + 1;

        LinkedList<Integer> merged = new LinkedList<>();
        while (k1 <= mid && k2 <= end) {
            if (nums[k1] <= nums[k2])
                merged.addLast(nums[k1++]);
            else {
                merged.addLast(nums[k2++]);
            }
        }

        while (k1 <= mid) merged.addLast(nums[k1++]);
        while (k2 <= end) merged.addLast(nums[k2++]);
        int i = st;
        for (int ele : merged) {
            nums[i++] = ele;
        }
        return count;
    }
}
