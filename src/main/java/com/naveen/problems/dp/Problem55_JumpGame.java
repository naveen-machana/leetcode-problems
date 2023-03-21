package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/jump-game/
* You are given an integer array nums. You are initially positioned at the array's first index, and each element
* in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise
Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
* impossible to reach the last index.
*
* */
public class Problem55_JumpGame {
    public boolean canJump4(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--)
            if (i + nums[i] >= goal)
                goal = i;
        return goal == 0;
    }

    public boolean canJump3(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return jump3(nums, 0, nums.length, dp);
    }

    private boolean jump3(int[] a, int i, int n, Boolean[] dp) {
        if (i >= n - 1) return true;
        if (dp[i] != null) return dp[i];
        boolean res = false;

        for (int j = 1; j <= a[i]; j++) {
            if (j + a[j] >= n - 1) {
                res = true;
                break;
            }
            else if (jump3(a, j + i, n, dp)) {
                res = true;
                break;
            }
        }
        dp[i] = res;
        return dp[i];
    }

    public boolean canJump2(int[] nums) {
        return jump(nums, nums.length);
    }
    private boolean jump(int[] a, int n) {
        if (n == 1) return true;
        boolean subres = false;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] + i >= n - 1) {
                subres = jump(a, i + 1);
                if (subres) return true;
            }
        }
        return subres;
    }

    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (farthest < i) return false;
            farthest = Math.max(i + nums[i], farthest);
        }
        return true;
    }
}
