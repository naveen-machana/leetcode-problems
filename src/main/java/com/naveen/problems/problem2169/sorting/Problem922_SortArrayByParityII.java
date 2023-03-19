package com.naveen.problems.problem2169.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/sort-array-by-parity-ii/
* Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
* Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
* Return any answer array that satisfies this condition.
* Input: nums = [4,2,5,7]
* Output: [4,5,2,7]
* Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
* */
public class Problem922_SortArrayByParityII {
    public int[] sortArrayByParityII(int[] a) {
        int even = 0, odd = 1, n = a.length;
        while (even < n && odd < n) {
            while (even < n && a[even] % 2 == 0) even += 2;
            while (odd < n && a[odd] % 2 == 1) odd += 2;
            if (even < n && odd < n) {
                int tmp = a[even];
                a[even] = a[odd];
                a[odd] = tmp;
                even += 2;
                odd += 2;
            }
        }
        return a;
    }
}
