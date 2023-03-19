package com.naveen.problems.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/wiggle-sort-ii/
* Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
* You may assume the input array always has a valid answer.
* Input: nums = [1,5,1,2,6,4]
* Output: [2,6,1,5,1,4]
* 1,1,2,4,5,6
* step1 : sort array
* step2 : place larger elements on odd positions
* _ 6 _ 5 _ 4
* step3 : reset i to start from 0 to fill even positions
*  2 6 1 5 1 4
* */
public class Problem324_WiggleSortII {
    public void wiggleSort(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int j = n - 1, i = 1;
        int[] res = new int[n];
        while (i < n) {
            res[i] = a[j--];
            i += 2;
        }
        i = 0;
        while (i < n) {
            res[i] = a[j--];
            i += 2;
        }
        i = 0;
        for (int x : res) a[i++] = x;
    }
}
