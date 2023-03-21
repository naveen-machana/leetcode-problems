package com.naveen.problems.dp;

/*
https://leetcode.com/problems/jump-game-ii/
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that
you can reach nums[n - 1].

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
then 3 steps to the last index.
* */
public class Problem45_JumpGame2 {
    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        Problem45_JumpGame2 sol = new Problem45_JumpGame2();
        System.out.println(sol.jump(a));
    }
    // shortest path can be achieved by doing a BFS. Here we are doing BFS traversal, to find the minimum no. of
    // steps required to reach to the end of the array. BFS on one dimensional array.
    public int jump2(int[] nums) {
        int res = 0, l = 0, r = 0;
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++)
                farthest = Math.max(farthest, i + nums[i]);
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }

    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (curEnd == i) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
