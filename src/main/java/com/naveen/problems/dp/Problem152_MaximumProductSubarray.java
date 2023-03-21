package com.naveen.problems.dp;

import java.util.Arrays;

/*
* https://leetcode.com/problems/maximum-product-subarray
* Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
* */
public class Problem152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int res = Arrays.stream(nums).max().getAsInt();
        int max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = max * nums[i];
            max = max(temp, min * nums[i], nums[i]);
            min = min(temp, min * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
