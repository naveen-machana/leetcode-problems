package com.naveen.problems.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to
the right of nums[i].

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

* */
public class Problem315_CountSmallerOnRightSide {
    public static void main(String[] args) {
        Problem315_CountSmallerOnRightSide sol = new Problem315_CountSmallerOnRightSide();
        System.out.println(sol.countSmaller(new int[]{5,2,6,1}));
    }
    private static class Element {
        int val, index, count;
        public Element(int val, int index) { this.val = val; this.index = index; }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Element[] a = new Element[nums.length];
        for (int i = 0; i < nums.length; i++) a[i] = new Element(nums[i], i);
        mergedAndCount(a, 0, nums.length - 1);
        Integer[] resArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            resArr[a[i].index] = a[i].count;
        }
        return Arrays.asList(resArr);
    }

    private void mergedAndCount(Element[] a, int st, int end) {
        if (st >= end) return;
        int mid = (st + end)/2;
        mergedAndCount(a, st, mid);
        mergedAndCount(a, mid + 1, end);
        merge(a, st, mid, end);
    }

    private void merge(Element[] a, int st, int mid, int end) {
        int k1 = st, k2 = mid + 1, count = 0;
        for (; k1 <= mid; k1++) {
            while (k2 <= end && a[k2].val < a[k1].val) {
                count++; k2++;
            }
            a[k1].count += count;
        }
        k1 = st; k2 = mid + 1;
        LinkedList<Element> merged = new LinkedList<>();
        while (k1 <= mid && k2 <= end) {
            if (a[k1].val <= a[k2].val) merged.add(a[k1++]);
            else merged.add(a[k2++]);
        }
        while (k1 <= mid) merged.add(a[k1++]);
        while (k2 <= end) merged.add(a[k2++]);
        for (int i = st; i <= end; i++) {
            a[i] = merged.removeFirst();
        }
    }
}
