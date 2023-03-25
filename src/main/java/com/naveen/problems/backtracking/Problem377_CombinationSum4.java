package com.naveen.problems.backtracking;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/combination-sum-iv
* Given an array of distinct integers nums and a target integer target, return the number of possible combinations
* that add up to target.

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

 * */
public class Problem377_CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        return ways(nums, nums.length, target, dp);
    }

    private int ways(int[] a, int n, int target, Map<Integer, Integer> dp) {
        if (target == 0) return 1;
        if (dp.containsKey(target)) return dp.get(target);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= target)
                res += ways(a, n, target - a[i], dp);
        }
        dp.put(target, res);
        return dp.get(target);
    }
}
