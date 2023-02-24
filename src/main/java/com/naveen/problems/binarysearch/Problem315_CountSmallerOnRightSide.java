package com.naveen.problems.binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        int val, index;
        public Element(int val, int index) { this.val = val; this.index = index; }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Element[] a = new Element[nums.length];
        for (int i = 0; i < nums.length; i++) a[i] = new Element(nums[i], i);
        int[] res = new int[nums.length];

        mergeAndCount(a, 0, nums.length - 1, res);
        List<Integer> resList = new ArrayList<>(nums.length);
        for (int ele : res) resList.add(ele);
        return resList;
    }

    private void mergeAndCount(Element[] a, int st, int end, int[] res) {
        if (st >= end) return;
        int m = (st + end)/2;
        mergeAndCount(a, st, m, res);
        mergeAndCount(a, m + 1, end, res);
        merge(a, st, m, end, res);
    }

    private void merge(Element[] a, int st, int m, int end, int[] res) {
        int i = st, j = m + 1;
        LinkedList<Element> merged = new LinkedList<>();
        int numEleInRightLessThanLeft = 0;
        while (i <= m && j <= end) {
            if (a[i].val > a[j].val) {
                numEleInRightLessThanLeft++;
                merged.add(a[j++]);
            }
            else {
                res[a[i].index] = res[a[i].index] + numEleInRightLessThanLeft;
                merged.add(a[i++]);
            }
        }
        while (i <= m) {
            res[a[i].index] = res[a[i].index] + numEleInRightLessThanLeft;
            merged.add(a[i++]);
        }
        while (j <= end) {
            merged.add(a[j++]);
        }
        i = st;
        while (i <= end) {
            a[i++] = merged.removeFirst();
        }
    }
}
