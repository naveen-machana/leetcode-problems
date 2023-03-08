package com.naveen.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* */
public class Problem78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       subsets(nums, res, new ArrayList<>(), 0);
       return res;
    }

    private void subsets(int[] a, List<List<Integer>> res, List<Integer> cur, int st) {
        res.add(new ArrayList<>(cur));
        for (int i = st; i < a.length; i++) {
            cur.add(a[i]);
            subsets(a, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
