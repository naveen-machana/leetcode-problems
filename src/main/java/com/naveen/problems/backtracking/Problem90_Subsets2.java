package com.naveen.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/subsets-ii/
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
* */
public class Problem90_Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void subsets(int[] nums, List<List<Integer>> res, List<Integer> cur, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        subsets(nums, res, cur, i + 1);
        cur.remove(cur.size() - 1);
        int j = i + 1;
        while (j < nums.length && nums[j] == nums[j - 1]) j++;
        subsets(nums, res, cur, j);
    }
}
