package com.naveen.problems.problem2169.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/sort-array-by-parity/
* Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
* Return any array that satisfies this condition.
* Input: nums = [3,1,2,4]
* Output: [2,4,3,1]
* Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
* */
public class Problem905_SortArrayByParity {
    public int[] sortArrayByParity(int[] a) {
        int st = 0, n = a.length;
        for (int j = 0; j < n; j++) {
            if (a[j] % 2 == 0) {
                swap(a, st, j);
                st++;
            }
        }
        return a;
    }

    private void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
}
