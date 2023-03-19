package com.naveen.problems.problem2169.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/array-partition/
* Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
* such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
* Input: nums = [6,2,6,5,1,2]
* Output: 9
* Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
* */
public class Problem561_ArrayPartition {
    public int arrayPairSum(int[] a) {
        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < a.length; i += 2) sum += a[i];
        return sum;
    }
}
