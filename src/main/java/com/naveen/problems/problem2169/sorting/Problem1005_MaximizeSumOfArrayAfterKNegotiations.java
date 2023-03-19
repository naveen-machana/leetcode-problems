package com.naveen.problems.problem2169.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/description/
* Given an integer array nums and an integer k, modify the array in the following way:
* choose an index i and replace nums[i] with -nums[i].
* You should apply this process exactly k times. You may choose the same index i multiple times.
* Return the largest possible sum of the array after modifying it in this way.
* Input: nums = [4,2,3], k = 1
* Output: 5
* Explanation: Choose index 1 and nums becomes [4,-2,3].
* */
public class Problem1005_MaximizeSumOfArrayAfterKNegotiations {
    // approach 1
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int st = 0, n = nums.length, sum = 0, min = Integer.MAX_VALUE;
        while (k > 0 && st < n && nums[st] < 0) {
            nums[st] = -nums[st];
            sum += nums[st];
            min = Math.min(min, nums[st]);
            st++;
            k--;
        }

        while (st < n) {
            sum += nums[st];
            min = Math.min(min, nums[st]);
            st++;
        }

        return k % 2 == 0 ? sum : sum - 2 * min;
    }
}
