package com.naveen.problems.arrays.problem18;

import java.util.*;

// https://leetcode.com/problems/4sum/
// 18. 4Sum
// Given an array nums of n integers, return an array of all the unique quadruplets
// [nums[a], nums[b], nums[c], nums[d]] such that:
//
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return ksum(nums, 4, target, 0);
    }

    private List<List<Integer>> ksum(int[] a, int k, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();

        if (start == a.length) return res;
        if (k == 2) return twoSum(a, start, target);

        for (int i = start; i < a.length; i++) {
            for (List<Integer> subset : ksum(a, k - 1, target - a[i], i + 1)) {
                res.add(new ArrayList<>(Arrays.asList(a[i])));
                res.get(res.size() - 1).addAll(subset);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] a, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for (int i = start; i < a.length; i++) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != a[i]) {
                if (s.contains(target - a[i])) {
                    res.add(Arrays.asList(target - a[i], a[i]));
                }
            }
            s.add(a[i]);
        }

        return res;
    }
}
