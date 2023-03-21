package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/maximum-sum-circular-subarray/description
*
Example 1:
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
* */

public class Problem918_MaximumSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0, maxSumForward = maxSumSubarray(nums);
        boolean isAllNegative = true;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            isAllNegative &= (nums[i] < 0);
            nums[i] = -nums[i];
        }

        if (isAllNegative) return maxSumForward;
        int maxSumCircular = maxSumSubarray(nums);
        return Math.max(totalSum + maxSumCircular, maxSumForward);
    }

    private int maxSumSubarray(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = Math.max(nums[i], nums[i] + sum);
            max = Math.max(max, cur);
            sum = cur;
        }
        return max;
    }
}
