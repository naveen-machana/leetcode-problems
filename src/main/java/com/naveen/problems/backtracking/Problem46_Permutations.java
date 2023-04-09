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

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, 0);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, int i) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) cur.add(nums[j]);
            res.add(cur);
            return;
        }
        else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                permute(nums, res, i + 1);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
    }

}
