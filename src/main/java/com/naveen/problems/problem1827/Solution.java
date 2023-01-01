package com.naveen.problems.problem1827;

public class Solution {
    public int minOperations(int[] nums) {
        int ops = 0, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ops += Math.max(0, last - nums[i] + 1);
            last = Math.max(nums[i], last + 1);
        }
        return ops;
    }
}
