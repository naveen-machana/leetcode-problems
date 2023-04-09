package com.naveen.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/*
https://leetcode.com/problems/permutations/
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
* */
public class Problem46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        permute(nums, res, cur, marked);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] marked) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                cur.add(nums[i]);
                permute(nums, res, cur, marked);
                marked[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

}
