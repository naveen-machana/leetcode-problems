package com.naveen.problems.problem2169.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/maximum-product-of-three-numbers/description/
* Given an integer array nums, find three numbers whose product is maximum and return the maximum product
* Input: nums = [-1,-2,-3]
* Output: -6
* 3 <= nums.length <= 104
* -1000 <= nums[i] <= 1000
* */
public class Problem628_MaximumProductOf3Numbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int firstTwoAndLast = nums[0] * nums[1] * nums[n - 1];
        int lastThree = nums[n - 1] * nums[n - 2] * nums[n - 3];
        return Math.max(firstTwoAndLast, lastThree);
    }

    public int maximumProduct2(int[] a) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MAX_VALUE, max3 = Integer.MAX_VALUE;
        for (int n : a) {
            if (n < min1)  {
                min2 = min1;
                min1 = n;
            }
            else if (n < min2) {
                min2 = n;
            }

            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if (n > max2) {
                max3 = max2;
                max2 = n;
            }
            else if (n > max3) {
                max3 = n;
            }
        }
        int firstTwoAndLast = min1 * min2 * max1;
        int lastThree = max1 * max2 * max3;
        return Math.max(firstTwoAndLast, lastThree);
    }
}
