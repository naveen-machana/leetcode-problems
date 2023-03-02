package com.naveen.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
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
        permutations(nums, res, 0);
        return res;
    }

    private void permutations(int[] a, List<List<Integer>> res, int st) {
        if (st == a.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : a) temp.add(i);
            res.add(temp);
            return;
        }
        for (int i = st; i < a.length; i++) {
            swap(a, i, st);
            permutations(a, res, st + 1);
            swap(a, i, st);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
